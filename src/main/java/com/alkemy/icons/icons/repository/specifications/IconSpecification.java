package com.alkemy.icons.icons.repository.specifications;



import com.alkemy.icons.icons.dto.IconFiltersDTO;
import com.alkemy.icons.icons.entity.IconEntity;
import com.alkemy.icons.icons.entity.PaisEntity;
import org.springframework.data.jpa.domain.Specification;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class IconSpecification{

	public Specification<IconEntity> getByFilters(IconFiltersDTO filtersDTO) {
		return (root, query, criteriaBuilder) -> {
		List<Predicate> predicates = new ArrayList<>();

		if (StringUtils.hasLength(filtersDTO.getName())) {
			predicates.add(
					criteriaBuilder.like(
							criteriaBuilder.lower(root.get("denominacion")),
							pattern:"%" + filtersDTO.getName().toLowerCase()+"%"
							)
					);
		}

		if (StringUtils.hasLength(filtersDTO.getDate())) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(filtersDTO.getDate(), formatter);

			predicates.add(criteriaBuilder.equal(root.<~>get("fechaCreacion"),
							date));

		}
		if (!CollectionUtils.isEmpty(filtersDTO.getCities())) {
			Join<PaisEntity, IconEntity> join = root.join(atributeName: "paises", JoinType.INNER);
			Expression<String> citiesId = join.get("id");
			predicates.add(citiesId.in(filtersDTO.getCities()));

		}
		//remove duplicates
		query.distinct(true);

		//order resolver

		String orderByField = "denominacion";
		query.orderBy(
				filtersDTO.isAsc()?
						criteriaBuilder.asc(root.get(orderByField)) :
						criteriaBuilder.desc(root.get(orderByField))

				);
		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
