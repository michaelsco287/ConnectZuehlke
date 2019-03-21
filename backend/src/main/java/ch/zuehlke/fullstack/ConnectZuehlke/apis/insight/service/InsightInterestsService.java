package ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.service;

import ch.zuehlke.fullstack.ConnectZuehlke.domain.Interests;

import java.util.List;

public interface InsightInterestsService {

    List<Interests> getInterests(String code);
}
