// @ts-ignore
import { KAPLANG_ID, KAPLANG_VERSION } from '@kapeta/kaplang-core';

export const includes = () => {
    return {
        version: KAPLANG_VERSION,
        language: KAPLANG_ID,
        source: `

            @Native("org.springframework.data.domain.Sort.Direction")
            enum SortOrderDirection {
                ASC,
                DESC
            }
            
            @Native("org.springframework.data.domain.Sort.Order")
            type SortOrder {
                direction: SortOrderDirection
                property: string
            }
            
            @Native("org.springframework.data.domain.Sort")
            type Sort {
                orders: SortOrder[]
            }
            
            @Native("org.springframework.data.domain.Pageable")
            type Pageable {
                page: long
                size: long
                sort: Sort
            }
            
            @Native("org.springframework.data.domain.Slice")
            type Slice<T> {
                content: T[]
                last: boolean
                first: boolean
                pageable: Pageable
            }
            
            @Native("org.springframework.data.domain.Page")
            type Page<T> extends Slice<T> {
                totalPages: long
                totalElements: long
            }
            `,
    };
};
