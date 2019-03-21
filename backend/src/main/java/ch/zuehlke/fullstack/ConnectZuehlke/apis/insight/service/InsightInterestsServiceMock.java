package ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.service;

import ch.zuehlke.fullstack.ConnectZuehlke.domain.Interests;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile({"ci", "default"})
public class InsightInterestsServiceMock implements InsightInterestsService {
    @Override
    public List<Interests> getInterests(String code) {
        List<Interests> interests = new ArrayList<>();
        interests.add(new Interests("Dancing", "13"));
        return null;
    }
}
