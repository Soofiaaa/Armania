package gameObject;

import gameObjectEnum.EntitieDescription;
import gameObjectEnum.EntitieName;

/**
 * Version 1.2
 * Author : Sofia
 **/

public class Map implements java.io.Serializable {
    // FINALS
    private static final short HEIGHT_MAX = 10;
    private static final short HEIGHT_MIN = 0;
    private static final short WIDTH_MAX = 10;
    private static final short WIDTH_MIN = 0;
    private final short heightMap = 10;
    private final short widthMap = 10;

    // VARIABLES
    private final Inventory inv = new Inventory();
    private Entities[][] map;
    private short heightPlayer;
    private short widthPlayer;
    private short mapSize;

    // CONSTRUCTOR
    public Map() {
        if (validateHeightMap(heightMap) && validateWidthMap(widthMap)) {
            map = new Entities[heightMap][widthMap];
            for (short x = 0; x < map.length; x++) {
                for (short y = 0; y < map.length; y++) {
                    map[x][y] = empty;
                    mapSize = (short) (x * y);
                }
            }
        }
        // PLAYER
        setPosition((short) 3, (short) 5);

        // CASTLE BEGINNING

        // VERTICAL
        place(castle_wall, (short) 3, (short) 3);
        place(castle_wall, (short) 3, (short) 4);
        place(castle_wall, (short) 3, (short) 6);
        place(castle_wall, (short) 3, (short) 7);
        place(castle_wall, (short) 7, (short) 3);
        place(castle_wall, (short) 7, (short) 4);
        place(castle_wall, (short) 7, (short) 6);
        place(castle_wall, (short) 7, (short) 7);
        place(castle_wall, (short) 4, (short) 3);
        place(castle_wall, (short) 6, (short) 3);
        place(castle_wall, (short) 7, (short) 3);

        // HORIZONTAL
        place(castle_wall, (short) 4, (short) 3);
        place(castle_wall, (short) 6, (short) 3);
        place(castle_wall, (short) 7, (short) 3);
        place(castle_wall, (short) 4, (short) 7);
        place(castle_wall, (short) 6, (short) 7);
        place(castle_wall, (short) 7, (short) 7);

        // TREES
        place(new Entities(EntitieName.TREE, EntitieDescription.TREE, (short) 1, (short) 30, (short) 30, inv.getTreeLog(), (short) 1, (short) 25), (short) 6, (short) 4);
        place(new Entities(EntitieName.TREE, EntitieDescription.TREE, (short) 1, (short) 30, (short) 30, inv.getTreeLog(), (short) 1, (short) 25), (short) 6, (short) 6);
        place(new Entities(EntitieName.TREE, EntitieDescription.TREE, (short) 1, (short) 30, (short) 30, inv.getTreeLog(), (short) 1, (short) 25), (short) 4, (short) 4);
        place(new Entities(EntitieName.TREE, EntitieDescription.TREE, (short) 1, (short) 30, (short) 30, inv.getTreeLog(), (short) 1, (short) 25), (short) 4, (short) 6);
        place(magical_fountain, (short) 5, (short) 5);
    }

    private Entities empty = new Entities(EntitieName.EMPTY, EntitieDescription.EMPTY);

    // ENTITIES
    private Entities castle_wall = new Entities(EntitieName.CASTLE_WALL, EntitieDescription.CASTLE_WALL);
    private Entities fountain = new Entities(EntitieName.FOUNTAIN, EntitieDescription.FOUNTAIN);
    private Entities magical_fountain = new Entities(EntitieName.MAGICAL_FOUNTAIN, EntitieDescription.MAGICAL_FOUNTAIN);

    // TREES
    private Entities tree = new Entities(EntitieName.TREE, EntitieDescription.TREE, (short) 1, (short) 30, (short) 30, inv.getTreeLog(), (short) 1, (short) 25);
    private Entities oakTree = new Entities(EntitieName.OAK_TREE, EntitieDescription.OAK_TREE, (short) 10, (short) 50, (short) 50, inv.getOakLog(), (short) 3, (short) 37.5);
    private Entities hackberryTree = new Entities(EntitieName.HACKBERRY_TREE, EntitieDescription.HACKBERRY_TREE, (short) 20, (short) 90, (short) 90, inv.getHackberryLog(), (short) 20, (short) 32);

    // GETS
    // ENTITIES
    public Entities getEmpty() {
        return empty;
    }

    public Entities getCastle_wall() {
        return castle_wall;
    }

    public Entities getFountain() {
        return fountain;
    }

    public Entities getMagical_fountain() {
        return magical_fountain;
    }

    public Entities getTree() {
        return tree;
    }

    public Entities getOakTree() {
        return oakTree;
    }

    public Entities getHackberryTree() {
        return hackberryTree;
    }

    public short getMapSize() {
        mapSize = heightMap * widthMap;
        return mapSize;
    }

    public short getHeightPlayer() {
        return heightPlayer;
    }

    public short getWidthPlayer() {
        return widthPlayer;
    }

    public String getPosition() {
        return "position : " + heightPlayer + "y " + widthPlayer + "x\n" + "You are on "
                + getPlace();
    }

    public Entities getPlace() {
        return map[heightPlayer][widthPlayer];
    }

    public String getMap() {
        String strMap = "";
        short x = widthPlayer;
        short y = heightPlayer;

        for (short i = 0; i < map.length; i++) {
            for (short j = 0; j < map.length; j++) {
                if (x == j && y == i) {
                    strMap += "P ";
                } else if (map[i][j] == empty) {
                    strMap += "e ";
                }
                // TREES
                else if (map[i][j].getName() == tree.getName() || map[i][j].getName() == oakTree.getName()|| map[i][j].getName() == hackberryTree.getName()) {
                    strMap += "T ";
                }
                // ENTITIES
                else if (map[i][j] == fountain || map[i][j] == magical_fountain) {
                    strMap += "F ";
                } else if (map[i][j] == castle_wall) {
                    strMap += "C ";
                }
                if (j == map.length - 1) {
                    strMap += "\n";
                }
            }
        }
        return strMap;
    }

    public String getInfoLocation() {
        return "This place is " + map[heightPlayer][widthPlayer] + ". " + map[heightPlayer][widthPlayer].getDescription();
    }

    // SETS
    public void setHeightPlayer(short pHeight) {
        if (validateHeight(pHeight)) {
            heightPlayer = pHeight;
        }
    }

    public void setWidthPlayer(short pWidth) {
        if (validateWidth(pWidth)) {
            widthPlayer = pWidth;
        }
    }

    public void setPosition(short pHeight, short pWidth) {
        if (validateHeight(pHeight) && validateWidth(pWidth)) {
            heightPlayer = pHeight;
            widthPlayer = pWidth;
        }
    }

    // VALIDATES
    public static boolean validateHeight(short pHeight) {
        return pHeight >= HEIGHT_MIN && pHeight < HEIGHT_MAX;
    }

    public static boolean validateWidth(short pWidth) {
        return pWidth >= WIDTH_MIN && pWidth < WIDTH_MAX;
    }

    public static boolean validateHeightMap(short pHeight) {
        return pHeight >= HEIGHT_MIN && pHeight <= HEIGHT_MAX;
    }

    public static boolean validateWidthMap(short pWidth) {
        return pWidth >= WIDTH_MIN && pWidth <= WIDTH_MAX;
    }

    // METHODS

    // MOVEMENTS
    public void moveUp() {
        if (validateHeight((short) (heightPlayer + 1)) && map[heightPlayer + 1][widthPlayer].getName() != castle_wall.getName()) {
            heightPlayer++;
            System.out.println(getMap());
            System.out.println(getPosition());
        } else {
            System.out.println("You can't go there.");
        }
    }

    public void moveDown() {
        if (validateHeight((short) (heightPlayer - 1)) && map[heightPlayer - 1][widthPlayer].getName() != castle_wall.getName()) {
            heightPlayer--;
            System.out.println(getMap());
            System.out.println(getPosition());
        } else {
            System.out.println("You can't go there.");
        }
    }

    public void moveRight() {
        if (validateWidth((short) (widthPlayer + 1)) && map[heightPlayer][widthPlayer + 1].getName() != castle_wall.getName()) {
            widthPlayer++;
            System.out.println(getMap());
            System.out.println(getPosition());
        } else {
            System.out.println("You can't go there.");
        }
    }

    public void moveLeft() {
        if (validateWidth((short) (widthPlayer - 1)) && map[heightPlayer][widthPlayer - 1].getName() != castle_wall.getName()) {
            widthPlayer--;
            System.out.println(getMap());
            System.out.println(getPosition());
        } else {
            System.out.println("You can't go there.");
        }
    }

    // PLACEMENT
    public void place(Entities pEntities, short pHeight, short pWidth) {
        map[pHeight][pWidth] = pEntities;
    }
}