import lt.vtvpmc.municipality.IllegalCitizenException;
import lt.vtvpmc.municipality.Municipality;
import lt.vtvpmc.municipality.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MunImpl implements Municipality {
    private List<Person> citizens = new ArrayList<>();

    @Override
    public void registerCitizen(Person person) throws IllegalCitizenException {
        boolean exists = citizens.stream()
                .anyMatch(citizens ->
                        citizens.getFirstName().equals(person.getFirstName()) &&
                                citizens.getLastName().equals(person.getLastName()) &&
                                citizens.getDateOfBirth().equals(person.getDateOfBirth()));
        if (person.getFirstName() == null || person.getLastName() == null || person.getDateOfBirth() == null || person.getYearlyIncome() < 0 || person.getDateOfBirth().isAfter(LocalDate.now())) {
            throw new IllegalCitizenException(person);
        }
        if (!exists) {
            citizens.add(person);
        }
    }

    @Override
    public boolean isRegisteredCitizen(Person person) {
        return citizens.stream()
                .anyMatch(citizens1 ->
                        citizens1.getFirstName().equals(person.getFirstName()) &&
                                citizens1.getLastName().equals(person.getLastName()) &&
                                citizens1.getDateOfBirth().equals(person.getDateOfBirth()));    }

    @Override
    public Person findOldestPerson() {
        Person oldestPerson = citizens.get(0);
        LocalDate oldestBirthday = oldestPerson.getDateOfBirth();

        for (Person person : citizens) {
            if (person.getDateOfBirth().isBefore(oldestBirthday)) {
                oldestPerson = person;
                oldestBirthday = person.getDateOfBirth();
            }
        }
        return oldestPerson;
    }

    @Override
    public double totalIncomeInTaxes() {
        double taxedIncome = 0.0;
        for (Person person : citizens) {
            double yearlyIncome = person.getYearlyIncome();
            if (person.getYearlyIncome() < 14000.0) {
            } else if (person.getYearlyIncome() > 1000000.0) {
                taxedIncome += yearlyIncome * 0.16;
            } else {
                taxedIncome += yearlyIncome * 0.15;
            }
        }
        return taxedIncome;    }

    @Override
    public int getCitizenCount() {
        return citizens.size();
    }
}
