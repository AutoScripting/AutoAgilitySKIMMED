package autoagilityskimmed.courses;

import autoagilityskimmed.util.Task;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Tile;

public class GnomeBasic extends Task {
    public enum Obstacles {
        LOG_BALANCE("Log balance", 69526, new Area(
                new Tile(2467, 3441, 0),
                new Tile(2467, 3435, 0),
                new Tile(2489, 3435, 0),
                new Tile(2489, 3441, 0)), "Walk-across"),
        OBSTACLE_NET("Obstacle net", 69383, new Area(
                new Tile(2469, 3431, 0),
                new Tile(2469, 3421, 0),
                new Tile(2479, 3421, 0),
                new Tile(2479, 3431, 0)), "Climb-over"),
        TREE_BRANCH_UP("Tree branch", 69508, new Area(
                new Tile(2470, 3425, 1),
                new Tile(2470, 3421, 1),
                new Tile(2478, 3421, 1),
                new Tile(2478, 3425, 1)), "Climb"),
        BALANCING_ROPE("Balancing rope", 2312, new Area(
                new Tile(2470, 3422, 2),
                new Tile(2470, 3418, 2),
                new Tile(2478, 3418, 2),
                new Tile(2478, 3422, 2)), "Walk-on"),
        TREE_BRANCH_DOWN("Tree branch", 69507, new Area(
                new Tile(2483, 3422, 2),
                new Tile(2483, 3416, 2),
                new Tile(2489, 3416, 2),
                new Tile(2489, 3422, 2)), "Climb-down"),
        SECOND_OBSTACLE_NET("Obstacle net", 69384, new Area(
                new Tile(2480, 3426, 0),
                new Tile(2480, 3412, 0),
                new Tile(2490, 3412, 0),
                new Tile(2490, 3426, 0)), "Climb-over"),
        OBSTACLE_PIPE("Obstacle pipe", 69378, new Area(
                new Tile(2480, 3432, 0),
                new Tile(2480, 3426, 0),
                new Tile(2490, 3426, 0),
                new Tile(2490, 3432, 0)), "Squeeze-through");
        final String obstacleName, obstacleInteraction;
        final int obstacleId;
        final Area obstacleArea;

        private Obstacles(final String obstacleName, final int obstacleId,
                          final Area obstacleArea, final String obstacleInteraction) {
            this.obstacleName = obstacleName;
            this.obstacleId = obstacleId;
            this.obstacleArea = obstacleArea;
            this.obstacleInteraction = obstacleInteraction;
        }

        public String getObstacleName() {
            return obstacleName;
        }

        public String getObstacleInteraction() {
            return obstacleInteraction;
        }

        public int getObstacleId() {
            return obstacleId;
        }

        public Area getObstacleArea() {
            return obstacleArea;
        }
    }

    public GnomeBasic(final MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !ctx.players.local().isInMotion() && ctx.players.local().getAnimation() == -1;
    }

    @Override
    public void execute() {
        for (Obstacles obstacles : Obstacles.values()) {
            if (obstacles.getObstacleArea().contains(ctx.players.local())) {
                final GameObject gameObject = ctx.objects.select().id(obstacles.getObstacleId()).nearest().poll();
                if (gameObject.isOnScreen()) {
                    gameObject.interact(obstacles.getObstacleInteraction(), obstacles.getObstacleName());
                } else {
                    ctx.camera.turnTo(gameObject);
                }
            }
        }
    }
}
