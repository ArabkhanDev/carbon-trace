package az.hakaton.karbon.repository;

import az.hakaton.karbon.model.UserCarbonData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCarbonDataRepository extends JpaRepository<UserCarbonData, Long> {
}