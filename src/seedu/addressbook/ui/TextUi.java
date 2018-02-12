package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;
import static seedu.addressbook.ui.Formatter.FormatterGetIndexedListForViewing;
import static seedu.addressbook.ui.Formatter.FormatterGetIndexedListItem;


import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Text UI of the application.
 */
public class TextUi {

    private final Scanner in;
    private final PrintStream out;
    private final Formatter formatter;
    public TextUi() {
        this(System.in, System.out);
    }

    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
        this.formatter = new Formatter(in, out);
    }


    /**
     * Prompts for the command and reads the text entered by the user.
     * Ignores empty, pure whitespace, and comment lines.
     * Echos the command back to the user.
     * @return command (full line) entered by the user
     */
    public String getUserCommand() {
        return formatter.getUserCommand();
    }


    public void showWelcomeMessage(String version, String storageFilePath) {
       this.formatter.showWelcomeMessage(version, storageFilePath);
    }

    public void showGoodbyeMessage() {
       formatter.showGoodbyeMessage();
    }


    public void showInitFailedMessage() {
        formatter.showInitFailedMessage();
    }

    /** Shows message(s) to the user */
    public void showToUser(String... message) {
        formatter.showToUser(message);
    }

    /**
     * Shows the result of a command execution to the user. Includes additional formatting to demarcate different
     * command execution segments.
     */
    public void showResultToUser(CommandResult result) {
       formatter.showResultToUser(result);
    }

    /**
     * Shows a list of persons to the user, formatted as an indexed list.
     * Private contact details are hidden.
     */
    private void showPersonListView(List<? extends ReadOnlyPerson> persons) {
        formatter.showPersonListView(persons);
    }

    /** Formats a list of strings as a viewable indexed list. */
    private static String getIndexedListForViewing(List<String> listItems) {
        return FormatterGetIndexedListForViewing(listItems);
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return FormatterGetIndexedListItem(visibleIndex, listItem);
    }

}
