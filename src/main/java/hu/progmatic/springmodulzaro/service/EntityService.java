package hu.progmatic.springmodulzaro.service;

import hu.progmatic.springmodulzaro.model.Person;
import hu.progmatic.springmodulzaro.model.Preorder;
import hu.progmatic.springmodulzaro.repository.PersonRepository;
import hu.progmatic.springmodulzaro.repository.PreorderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class EntityService {

    private PersonRepository personRepository;
    private PreorderRepository preorderRepository;

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public List<Preorder> getAllPreorder() {
        return preorderRepository.findAll();
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public void savePreorder(Preorder preorder) {
        preorderRepository.save(preorder);
    }

    @Transactional
    public void deletePersonById(Integer id) {
        personRepository.deleteById(id);
    }

    @Transactional
    public void deletePreorderByPerson(Person person) {
        preorderRepository.deleteAllByPerson(person);
    }

    public List<Preorder> getAllPreorderByPerson(Person person) {
        return preorderRepository.getPreorderByPerson(person);
    }

    public Person getPersonById(Integer id) {
        return personRepository.findById(id).orElse(null);
    }
}
