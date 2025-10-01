package exerciseTwo;

import java.util.ArrayList;
import java.util.Arrays;

public class Interpretor {

    private String prioritySetter(String priority) {
        switch (priority.toLowerCase().trim()) {
            case "high":
            case "h":
                return "high";
            case "medium":
            case "m":
                return "medium";
            case "low":
            case "l":
                return "low";
            default:
                return "medium";
        }
    }

    private boolean taskExists(String taskName) {
        // Placeholder for actual task existence check
        // In a real implementation, this would check against a list or database of
        // tasks
        return true; // Assume the task exists for this example
    }

    private boolean containsIgnoreCase(ArrayList<String> list, String str) {
        for (String s : list) {
            if (s.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
    // private void updateTask(String taskName, String field, String newValue) {
    //     // Placeholder for actual task update logic
    //     // In a real implementation, this would update the task in a list or database
    //     System.out.println("Updating task: " + taskName + " at " + field + ": " + newValue);
    // }

    public String[] interpret(String command) {
        command = command.trim();
        System.out.println("Interpreting command: " + command);
        // now we will implement the logic (explained in readme) in the Interpretor
        // section
        String[] parts = command.split(" ", 2);
        String action = parts[0].trim();

        // crud operations command options (ways to input)
        ArrayList<String> create = new ArrayList<>(Arrays.asList("create", "c", "add", "a"));
        ArrayList<String> remove = new ArrayList<>(Arrays.asList("remove", "r", "delete", "d"));
        ArrayList<String> update = new ArrayList<>(Arrays.asList("update", "u", "edit", "e"));
        ArrayList<String> view = new ArrayList<>(Arrays.asList("view", "v", "list", "l"));

        String taskName, startTime, endTime, priority;

        if (containsIgnoreCase(create, action)) {
            // if length if not 5 (ie missing some info)

            try {
                action = "create";
                if (parts[1].trim().charAt(0) == '\"') {
                    int closingQuoteIndex = parts[1].indexOf('\"', 1);
                    if (closingQuoteIndex == -1) {
                        System.out.println("Error: Invalid command format. Missing closing quote for taskName.");
                        return null;
                    }
                    taskName = parts[1].substring(0, closingQuoteIndex + 1).trim();

                    String remaining = parts[1].substring(closingQuoteIndex + 1).trim();
                    String[] remainingParts = remaining.split(" ");
                    if (remainingParts.length < 3) {
                        System.out.println(
                                "Error: Invalid command format. Please provide startTime, endTime, and priority after the taskName");
                        return null;
                    }
                    startTime = remainingParts[0].trim();
                    endTime = remainingParts[1].trim();
                    if (remainingParts.length < 3) {
                        priority = "medium"; // default priority
                    } else {
                        priority = prioritySetter(remainingParts[2].trim());
                    }
                } else {
                    String[] subParts = parts[1].trim().split(" ");
                    if (subParts.length < 3) {
                        System.out.println(
                                "Error: Invalid command format. Please provide taskName, startTime, endTime, and priority followed after the action with spaces");
                        return null;
                    }
                    taskName = subParts[0].trim();
                    startTime = subParts[1].trim();
                    endTime = subParts[2].trim();
                    if (subParts.length < 4) {
                        priority = "medium"; // default priority
                    } else {
                        priority = prioritySetter(subParts[3].trim());
                    }

                }
                return new String[] { action, taskName, startTime, endTime, priority };
            } catch (Exception e) {
                System.out.println(
                        "Error: Invalid command format. Please provide taskName, startTime, endTime, and priority followed after the action with spaces");
                return null;
            }

        } else if (containsIgnoreCase(remove, action)) {
            try {
                action = "remove";
                taskName = parts[1].trim(); // whatever is there after the space
                return new String[] { action, taskName };
            } catch (Exception e) {
                System.out.println(
                        "Error: Invalid command format. Please provide taskName followed after the action with a space");
                return null;
            }
        } else if (containsIgnoreCase(update, action)) {
            try {
                action = "update";
                // check the task name is in list of tasks
                String remainingPart;
                if (parts[1].trim().charAt(0) == '\"') {
                    int closingQuoteIndex = parts[1].indexOf('\"', 1);
                    if (closingQuoteIndex == -1) {
                        System.out.println("Error: Invalid command format. Missing closing quote for taskName.");
                        return null;
                    }
                    taskName = parts[1].substring(0, closingQuoteIndex + 1).trim();
                    remainingPart = parts[1].substring(closingQuoteIndex + 1).trim();
                } else {
                    String[] subParts = parts[1].trim().split(" ");
                    taskName = subParts[0].trim();
                    remainingPart = subParts[1].trim();
                }
                remainingPart = remainingPart.trim();
                if (taskExists(taskName)) {
                    // remaining parts -> two
                    String[] remainingParts = remainingPart.split(" ");
                    if (remainingParts.length != 2) {
                        System.out.println(
                                "Error: Invalid command format. Please provide startTime, endTime, and priority after the taskName");
                        return null;
                    }
                    // perform the update operation
                    return new String[] { action, taskName, remainingParts[0].trim(), remainingParts[1].trim() };
                    //updateTask(taskName, remainingParts[0], remainingParts[1]);
                } else {
                    System.out.println("Error: Task does not exist. Please provide a valid taskName to update.");
                    return null;
                }
            } catch (Exception e) {
                System.out.println(
                        "Error: Invalid command format. Please provide taskName followed by action and new value");
                return null;
            }
        } else if (containsIgnoreCase(view, action)) {
            action = "view";
            if (parts.length > 1) {
                String filter = parts[1].trim().toLowerCase();
                filter = prioritySetter(filter);
                return new String[] { action, filter };
            }
            return new String[] { action };
        } else if (action.equalsIgnoreCase("exit") || action.equalsIgnoreCase("quit")) {
            action = "exit";
            return new String[] { action };
        } else if (action.equalsIgnoreCase("help") || action.equalsIgnoreCase("h")) {
            action = "help";
            return new String[] { action };
        } else {
            System.out.println("Error: Unknown action. Please use create(c), remove(r), update(u), or view(v)");
            return null;
        }
    }

}
