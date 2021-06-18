package com.solution.academy.courses.application.search_last;


import com.solution.academy.courses.application.CoursesResponse;
import com.solution.shared.domain.Service;
import com.solution.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchLastCoursesQueryHandler implements QueryHandler<SearchLastCoursesQuery, CoursesResponse> {
    private final LastCoursesSearcher searcher;

    public SearchLastCoursesQueryHandler(LastCoursesSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public CoursesResponse handle(SearchLastCoursesQuery query) {
        return searcher.search(query.total());
    }
}
