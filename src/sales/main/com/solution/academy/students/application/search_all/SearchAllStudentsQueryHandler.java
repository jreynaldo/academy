package com.solution.academy.students.application.search_all;

import com.solution.academy.students.application.StudentsResponse;
import com.solution.shared.domain.Service;
import com.solution.shared.domain.bus.query.QueryHandler;


@Service
public final class SearchAllStudentsQueryHandler implements QueryHandler<SearchAllStudentsQuery, StudentsResponse> {
    private final AllStudentsSearcher searcher;

    public SearchAllStudentsQueryHandler(AllStudentsSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public StudentsResponse handle(SearchAllStudentsQuery query) {
        return searcher.search();
    }
}
