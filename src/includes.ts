// @ts-ignore
import { KAPLANG_ID, KAPLANG_VERSION } from '@kapeta/kaplang-core';
import { DSLInclude, IncludeContextType } from '@kapeta/ui-web-types';

export const includes = (context: IncludeContextType = IncludeContextType.REST): DSLInclude => {
    if (context === IncludeContextType.CONFIG) {
        // These types are for entities only
        return {
            version: KAPLANG_VERSION,
            language: KAPLANG_ID,
            source: '',
        };
    }
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
                page?: long
                size?: long
                sort?: SortOrder[]
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
