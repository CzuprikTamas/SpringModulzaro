package hu.progmatic.springmodulzaro.repository;

import hu.progmatic.springmodulzaro.model.Person;
import hu.progmatic.springmodulzaro.model.Preorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreorderRepository extends JpaRepository<Preorder, Integer> {
    List<Preorder> getPreorderByPerson(Person person);

    void deleteAllByPerson(Person person);
}
