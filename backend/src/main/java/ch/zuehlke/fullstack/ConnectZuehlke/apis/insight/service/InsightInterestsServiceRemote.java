package ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.service;

import ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.dto.EmployeeDto;
import ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.dto.InterestsDto;
import ch.zuehlke.fullstack.ConnectZuehlke.domain.Interests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpMethod.GET;

@Service
@Profile({"prod", "staging"})
public class InsightInterestsServiceRemote implements  InsightInterestsService {

    private final RestTemplate insightRestTemplate;

    @Autowired
    public InsightInterestsServiceRemote(RestTemplate insightRestTemplate) {
        this.insightRestTemplate = insightRestTemplate;
    }

    @Override
    public List<Interests> getInterests(String code) {
        String url = "/employees/"+code+"/interests";
        ResponseEntity<List<InterestsDto>> response = this.insightRestTemplate
                .exchange(url, GET, null, new ParameterizedTypeReference<List<InterestsDto>>() {
                });

        return response.getBody().stream()
                .map(InterestsDto::toInterests)
                .collect(toList());
    }
}
