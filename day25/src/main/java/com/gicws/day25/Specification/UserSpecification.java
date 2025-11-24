package com.gicws.day25.Specification;

import com.gicws.day25.Entity.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> hasName(String name) {
        return (root, query, cb) ->
                (name == null) ? null : cb.equal(root.get("name"), name);
    }

    public static Specification<User> hasEmail(String email) {
        return (root, query, cb) ->
                (email == null) ? null : cb.like(root.get("email"), "%" + email + "%");
    }

    public static Specification<User> ageBetween(Integer min, Integer max) {
        return (root, query, cb) -> {
            if (min == null && max == null) return null;
            if (min != null && max != null) return cb.between(root.get("age"), min, max);
            if (min != null) return cb.greaterThanOrEqualTo(root.get("age"), min);
            return cb.lessThanOrEqualTo(root.get("age"), max);
        };
    }
}
