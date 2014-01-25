package autoagilityskimmed.handlers;

import autoagilityskimmed.data.FoodData;
import autoagilityskimmed.util.Task;
import org.powerbot.script.methods.Hud;
import org.powerbot.script.methods.MethodContext;

public class FoodHandler extends Task {
    final FoodData foodData;

    public FoodHandler(final MethodContext ctx, final FoodData foodData) {
        super(ctx);
        this.foodData = foodData;
    }

    @Override
    public boolean activate() {
        final String[] strArray = ctx.widgets.get(1430, 83).getChild(7).getText().split("/");
        final int currentHealth = Integer.parseInt(strArray[0]);
        final int maxHealth = Integer.parseInt(strArray[1]);
        return ((currentHealth * 2) < maxHealth)
                && ctx.hud.view(Hud.Window.BACKPACK)
                && !ctx.backpack.select().id(foodData.getFoodId()).isEmpty();
    }

    @Override
    public void execute() {
        ctx.backpack.select().id(foodData.getFoodId()).first().poll().interact("Eat");
    }
}
