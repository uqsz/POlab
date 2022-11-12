package agh.ics.oop;

class SimulationEngine implements IEngine{
    public final MoveDirection[] directions;
    public final IWorldMap map;
    public final Vector2d[] positions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.directions = directions;
        this.map = map;
        this.positions = positions;
        for (Vector2d position : positions) {
            map.place(new Animal(map, position));
        }
    }
    @Override
    public void run() {
        int i=0;
        int n=positions.length;
        for (MoveDirection direction : directions){
            Animal tempAnimal = (Animal) map.objectAt(positions[i%n]);
            tempAnimal.move(direction);
            positions[i%n] = tempAnimal.getPosition();
            i+=1;
        }
    }
}
