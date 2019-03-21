package ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.service;

import ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.dto.InterestsDto;
import ch.zuehlke.fullstack.ConnectZuehlke.common.exceptionHandling.ResourceNotFoundException;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProdInsightInterestServiceTest {

    @Test
    public void callsInsightWithCorrectCodeTest(){
        ArgumentCaptor<String> code = ArgumentCaptor.forClass(String.class);
        RestTemplate mock = mock(RestTemplate.class);
        List<InterestsDto> listInterests = new ArrayList<>();
        listInterests.add(new InterestsDto("PowerPuff Girls", "1"));
        ResponseEntity<List<InterestsDto>> mockResponse = new ResponseEntity<>(listInterests, HttpStatus.OK);
        when(mock.exchange(anyString(), any(HttpMethod.class), any(), any(ParameterizedTypeReference.class))).thenReturn(mockResponse);
        InsightInterestsService service = new InsightInterestsServiceRemote(mock);
        String expectedCode = "/employees/alha/interests";

        service.getInterests("alha");

        verify(mock).exchange(code.capture(), any(HttpMethod.class), any(), any(ParameterizedTypeReference.class));

        assertEquals(expectedCode, code.getValue());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void callingWithInvalidCodeThrowsResourceNotFoundException(){
        RestTemplate mock = mock(RestTemplate.class);
        ResponseEntity<List<InterestsDto>> mockResponse = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        when(mock.exchange(anyString(), any(HttpMethod.class), any(), any(ParameterizedTypeReference.class))).thenReturn(mockResponse);
        InsightInterestsService service = new InsightInterestsServiceRemote(mock);
        service.getInterests("doesNotExist");

    }

}
