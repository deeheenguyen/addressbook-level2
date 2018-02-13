package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_SUCCESS = "List has been sorted";
    public static final String MESSAGE_EMPTY_LIST = "List is empty";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts the list in alphabetical order\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<Person> allPersons = addressBook.getAllPersons().getInternalList();
        if (allPersons.size() == 0){
            return new CommandResult(MESSAGE_EMPTY_LIST);
        }
        addressBook.getAllPersons().sortByAlphabetical();
        allPersons.sort(new AlphabeticalCompare());
        return new CommandResult(MESSAGE_SUCCESS);
    }

    private class AlphabeticalCompare implements Comparator<Person> {
        @Override
        public int compare(Person a, Person b) {
            return a.getName().toString().compareToIgnoreCase(b.getName().toString()) ;
        }
    }
}

