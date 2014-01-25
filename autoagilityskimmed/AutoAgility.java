package autoagilityskimmed;

import autoagilityskimmed.courses.GnomeBasic;
import autoagilityskimmed.data.FoodData;
import autoagilityskimmed.handlers.FoodHandler;
import autoagilityskimmed.util.Task;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;

import java.util.ArrayList;

@Manifest(
        authors = {"AutoScript"},
        topic = 0,
        version = 0,
        name = "Auto Agility SOURCE",
        description = "The open-source skimmed version of auto agility!")
public class AutoAgility extends PollingScript {

    private final ArrayList<Task> mainTask = new ArrayList<Task>();

    @Override
    public void start() {
        mainTask.add(new GnomeBasic(ctx));
        mainTask.add(new FoodHandler(ctx, FoodData.LOBSTERS));
    }

    @Override
    public int poll() {
        for (Task task : mainTask) {
            if (task.activate()) {
                task.execute();
                return 1000;
            }
        }
        return 250;
    }
}