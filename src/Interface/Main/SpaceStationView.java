package Interface.Main;

import GameObjects.Zone;
import GameObjects.Zones.Building;
import GameObjects.Zones.Buildings.Hangar;
import Interface.MainPanel;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class SpaceStationView extends MainPanel {

    private static final String IPANELNAME = "Buildings";

    private ArrayList<Building> neighbours;

    private int rbWidth = 0;

    private static final int numBuildings = 24;

    private static final int HALLARRIVE = 17;

    private ArrayList<Building> listBuilding;
    private ArrayList<Hangar> listHangars;
    private String[] namesBuildings;
    private int[] posBuildings;
    private int[] maxCapBuilding;
    private int[] tail;
    private int[] head;

    public SpaceStationView(String n, int sW, int mW, int tH, int tW, String sound) {
        super(n, sW, mW, tW, tH, Building.class, IPANELNAME, sound);

        namesBuildings = new String[]{"Salle de Commandement", "Cinema", "Dortoirs", "Police", "Prison", "Hôtel", "Bar", "Dortoirs", "Pompiers", "Restaurant", "Hall Principal", "Magasin", "Jardins", "Entrepôts", "Entrepôts",
            "Vendeur d'armes", "Salle des machines", "Hall d'arrivée", "Salle de défense", "Hangar A", "Hangar B", "Hangar C", "Hangar D", "Hangar E"};
        
        posBuildings = new int[]{width / 2, height / 8, width / 6, height / 4, width / 3, height / 8, 2 * width / 3, height / 8, 5 * width / 6, height / 4, width / 6, 3 * height / 8, width / 3, height / 4, 2 * width / 3, height / 4, 5 * width / 6, 3 * height / 8, width / 6, height / 2, width / 2, height / 2, 5 * width / 6, height / 2, width / 6, 5 * height / 8, width / 3, 5 * height / 8, 2 * width / 3, 5 * height / 8, 5 * width / 6, 5 * height / 8, width / 6, 3 * height / 4, width / 2, 3 * height / 4, 5 * width / 6, 3 * height / 4, width / 6, 7 * height / 8, width / 3, 7 * height / 8, width / 2, 7 * height / 8, 2 * width / 3, 7 * height / 8, 5 * width / 6, 7 * height / 8};

        maxCapBuilding = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1500, 500, 750, 500, 1000};
        tail = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        head = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 17, 10, 17, 17, 17, 17, 17, 17};
        //#ROP

        listBuilding = new ArrayList();
        listHangars = new ArrayList();
        neighbours = new ArrayList();
        for (int i = 0; i < numBuildings; i++) {
            //listBuilding.add(new Building(namesBuildings[i], maxCapBuilding[i], tailleBuildings[2 * i], tailleBuildings[(2 * i) + 1], sW + posBuildings[2 * i] - (tailleBuildings[2 * i] / 2),topHeight +  posBuildings[(2 * i) + 1] - (tailleBuildings[(2 * i) + 1] / 2), i));
            if (i < numBuildings - 5) {
                listBuilding.add(new Building(namesBuildings[i], maxCapBuilding[i], sW + posBuildings[2 * i], topHeight + posBuildings[(2 * i) + 1], "test", sWidth, topHeight));
            } else {
                //test!
                neighbours.add(listBuilding.get(HALLARRIVE));
                Hangar hangar = new Hangar(namesBuildings[i], maxCapBuilding[i], sW + posBuildings[2 * i], topHeight + posBuildings[(2 * i) + 1], sWidth, topHeight, neighbours);
                listHangars.add(hangar);
                listBuilding.add(hangar);
            }

        }
        System.out.println(listBuilding.get(numBuildings - 5).getName());

        this.iPanel.setBuildingsList(listBuilding);
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        int coordX = 0;
        int coordY = 0;
        int coordXb = 0;
        int coordYb = 0;
        g.setStroke(PASSIVE_STROKE);
        for (int j = 0; j <= tail.length - 1; j++) {
            coordX = listBuilding.get(tail[j]).getPosX() + (listBuilding.get(tail[j]).getWidth() / 2);
            coordY = listBuilding.get(tail[j]).getPosY() + (listBuilding.get(tail[j]).getHeight() / 2);
            coordXb = listBuilding.get(head[j]).getPosX() + (listBuilding.get(head[j]).getWidth() / 2);
            coordYb = listBuilding.get(head[j]).getPosY() + (listBuilding.get(head[j]).getWidth() / 2);

            g.drawLine(coordX, coordY, coordXb, coordYb);
        }

        int fontSize = tWidth / 100;
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        for (int z = 0; z < listBuilding.size(); z++) {
            listBuilding.get(z).draw(g);
        }
        g.setStroke(ACTIVE_STROKE);
    }

    @Override
    public void update() {
        super.update();

        if (isSliding) {
            slideMap();
        }
    }

    public void slideMap() {
        if (detailBarOn && isSliding) {
            for (int i = 0; i < listBuilding.size(); i++) {
                if (listBuilding.get(i).getPosX() - this.rightBarWidth + rbWidth > listBuilding.get(i).getInitPosX() - (tWidth - (tWidth / 5)) / 10) {
                    listBuilding.get(i).setPosX(listBuilding.get(i).getPosX() - this.rightBarWidth + rbWidth);
                }
            }
        } else {
            for (int i = 0; i < listBuilding.size(); i++) {
                if (listBuilding.get(i).getPosX() < listBuilding.get(i).getInitPosX()) {
                    listBuilding.get(i).setPosX(listBuilding.get(i).getPosX() - this.rightBarWidth + rbWidth);
                }
            }

        }
        rbWidth = this.rightBarWidth;
    }

    public ArrayList<Building> getListBuildings() {
        return listBuilding;
    }

    public ArrayList<Hangar> getListHangars() {
        return listHangars;
    }

}
