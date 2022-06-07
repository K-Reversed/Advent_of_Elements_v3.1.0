package Java.Main;

import Java.Entity.Entity;

import java.util.Objects;

public record EntityCollision(GUI gPanel) {
    public void tileCollision(Entity entity) {
        int entityLeft = (entity.getWorldX() - gPanel().getTileSize()) + entity.getHitBox().x;
        int entityRight = (entity.getWorldX() - gPanel().getTileSize()) + entity.getHitBox().x + entity.getHitBox().width;
        int entityTop = (entity.getWorldY() - (gPanel().getTileSize() / 2)) + entity.getHitBox().y;
        int entityBottom = (entity.getWorldY() - gPanel().getTileSize()) + entity.getHitBox().y + entity.getHitBox().height;
        int entityLeftBound = entityLeft / gPanel.getTileSize();
        int entityRightBound = entityRight / gPanel.getTileSize();
        int entityTopBound = entityTop / gPanel.getTileSize();
        int entityBottomBound = entityBottom / gPanel.getTileSize();
        int tileNum1L0 = 17, tileNum2L0 = 17, tileNum1L1 = 17, tileNum2L1 = 17;
        try {
            switch (entity.getInput()) {
                case ("up left"), ("up right") -> {
                    entityTopBound = (entityTop - entity.getVelocity()) / gPanel.getTileSize();
                    switch (gPanel.getTileL().getCurrentMap()) {
                        case ("OverWorld") -> {
                            tileNum1L0 = gPanel.getTileL().getMapArray().get(0)[entityLeftBound][entityTopBound];
                            tileNum2L0 = gPanel.getTileL().getMapArray().get(0)[entityRightBound][entityTopBound];
                            tileNum1L1 = gPanel.getTileL().getMapArray().get(1)[entityLeftBound][entityTopBound];
                            tileNum2L1 = gPanel.getTileL().getMapArray().get(1)[entityRightBound][entityTopBound];
                        }
                        case ("FireDungeon") -> {
                            tileNum1L0 = gPanel.getTileL().getMapArray().get(2)[entityLeftBound][entityTopBound];
                            tileNum2L0 = gPanel.getTileL().getMapArray().get(2)[entityRightBound][entityTopBound];
                            tileNum1L1 = gPanel.getTileL().getMapArray().get(3)[entityLeftBound][entityTopBound];
                            tileNum2L1 = gPanel.getTileL().getMapArray().get(3)[entityRightBound][entityTopBound];
                        }
//                        case ("WaterDungeon") -> {
//
//                        }
//                        case ("Wind Dungeon") -> {
//
//                        }
//                        case ("Earth Dungeon") -> {
//
//                        }
//                        case ("LightningDungeon") -> {
//
//                        }
//                        case ("DarkDungeon") -> {
//
//                        }
//                        case ("LightDungeon") -> {
//
//                        }
//                        case ("NatureDungeon") -> {
//
//                        }
//                        case ("MachinaDungeon") -> {
//
//                        }
                    }
                    if (gPanel.getTileL().getTileSet()[tileNum1L0].hasCollision() ||
                            gPanel.getTileL().getTileSet()[tileNum2L0].hasCollision() ||
                            gPanel.getTileL().getTileSet()[tileNum1L1].hasCollision() ||
                            gPanel.getTileL().getTileSet()[tileNum2L1].hasCollision()) {
                        entity.setCollision(true);
                    }
                }
                case ("left") -> {
                    entityLeftBound = (entityLeft - entity.getVelocity()) / gPanel.getTileSize();
                    switch (gPanel.getTileL().getCurrentMap()) {
                        case ("OverWorld") -> {
                            tileNum1L0 = gPanel.getTileL().getMapArray().get(0)[entityLeftBound][entityTopBound];
                            tileNum2L0 = gPanel.getTileL().getMapArray().get(0)[entityLeftBound][entityBottomBound];
                            tileNum1L1 = gPanel.getTileL().getMapArray().get(1)[entityLeftBound][entityTopBound];
                            tileNum2L1 = gPanel.getTileL().getMapArray().get(1)[entityLeftBound][entityBottomBound];
                        }
                        case ("FireDungeon") -> {
                            tileNum1L0 = gPanel.getTileL().getMapArray().get(2)[entityLeftBound][entityTopBound];
                            tileNum2L0 = gPanel.getTileL().getMapArray().get(2)[entityLeftBound][entityBottomBound];
                            tileNum1L1 = gPanel.getTileL().getMapArray().get(3)[entityLeftBound][entityTopBound];
                            tileNum2L1 = gPanel.getTileL().getMapArray().get(3)[entityLeftBound][entityBottomBound];
                        }
//                        case ("WaterDungeon") -> {
//
//                        }
//                        case ("Wind Dungeon") -> {
//
//                        }
//                        case ("Earth Dungeon") -> {
//
//                        }
//                        case ("LightningDungeon") -> {
//
//                        }
//                        case ("DarkDungeon") -> {
//
//                        }
//                        case ("LightDungeon") -> {
//
//                        }
//                        case ("NatureDungeon") -> {
//
//                        }
//                        case ("MachinaDungeon") -> {
//
//                        }
                    }
                    if (gPanel.getTileL().getTileSet()[tileNum1L0].hasCollision() ||
                            gPanel.getTileL().getTileSet()[tileNum2L0].hasCollision() ||
                            gPanel.getTileL().getTileSet()[tileNum1L1].hasCollision() ||
                            gPanel.getTileL().getTileSet()[tileNum2L1].hasCollision()) {
                        entity.setCollision(true);
                    }
                }
                case ("down left"), ("down right") -> {
                    entityBottomBound = (entityBottom + entity.getVelocity()) / gPanel.getTileSize();
                    switch (gPanel.getTileL().getCurrentMap()) {
                        case ("OverWorld") -> {
                            tileNum1L0 = gPanel.getTileL().getMapArray().get(0)[entityLeftBound][entityBottomBound];
                            tileNum2L0 = gPanel.getTileL().getMapArray().get(0)[entityRightBound][entityBottomBound];
                            tileNum1L1 = gPanel.getTileL().getMapArray().get(1)[entityLeftBound][entityBottomBound];
                            tileNum2L1 = gPanel.getTileL().getMapArray().get(1)[entityRightBound][entityBottomBound];
                        }
                        case ("FireDungeon") -> {
                            tileNum1L0 = gPanel.getTileL().getMapArray().get(2)[entityLeftBound][entityBottomBound];
                            tileNum2L0 = gPanel.getTileL().getMapArray().get(2)[entityRightBound][entityBottomBound];
                            tileNum1L1 = gPanel.getTileL().getMapArray().get(3)[entityLeftBound][entityBottomBound];
                            tileNum2L1 = gPanel.getTileL().getMapArray().get(3)[entityRightBound][entityBottomBound];
                        }
//                        case ("WaterDungeon") -> {
//
//                        }
//                        case ("Wind Dungeon") -> {
//
//                        }
//                        case ("Earth Dungeon") -> {
//
//                        }
//                        case ("LightningDungeon") -> {
//
//                        }
//                        case ("DarkDungeon") -> {
//
//                        }
//                        case ("LightDungeon") -> {
//
//                        }
//                        case ("NatureDungeon") -> {
//
//                        }
//                        case ("MachinaDungeon") -> {
//
//                        }
                    }
                    if (gPanel.getTileL().getTileSet()[tileNum1L0].hasCollision() ||
                            gPanel.getTileL().getTileSet()[tileNum2L0].hasCollision() ||
                            gPanel.getTileL().getTileSet()[tileNum1L1].hasCollision() ||
                            gPanel.getTileL().getTileSet()[tileNum2L1].hasCollision()) {
                        entity.setCollision(true);
                    }
                }
                case ("right") -> {
                    entityRightBound = (entityRight + entity.getVelocity()) / gPanel.getTileSize();
                    switch (gPanel.getTileL().getCurrentMap()) {
                        case ("OverWorld") -> {
                            tileNum1L0 = gPanel.getTileL().getMapArray().get(0)[entityRightBound][entityTopBound];
                            tileNum2L0 = gPanel.getTileL().getMapArray().get(0)[entityRightBound][entityBottomBound];
                            tileNum1L1 = gPanel.getTileL().getMapArray().get(1)[entityRightBound][entityTopBound];
                            tileNum2L1 = gPanel.getTileL().getMapArray().get(1)[entityRightBound][entityBottomBound];
                        }
                        case ("FireDungeon") -> {
                            tileNum1L0 = gPanel.getTileL().getMapArray().get(2)[entityRightBound][entityTopBound];
                            tileNum2L0 = gPanel.getTileL().getMapArray().get(2)[entityRightBound][entityBottomBound];
                            tileNum1L1 = gPanel.getTileL().getMapArray().get(3)[entityRightBound][entityTopBound];
                            tileNum2L1 = gPanel.getTileL().getMapArray().get(3)[entityRightBound][entityBottomBound];
                        }
//                        case ("WaterDungeon") -> {
//
//                        }
//                        case ("Wind Dungeon") -> {
//
//                        }
//                        case ("Earth Dungeon") -> {
//
//                        }
//                        case ("LightningDungeon") -> {
//
//                        }
//                        case ("DarkDungeon") -> {
//
//                        }
//                        case ("LightDungeon") -> {
//
//                        }
//                        case ("NatureDungeon") -> {
//
//                        }
//                        case ("MachinaDungeon") -> {
//
//                        }
                    }
                    if (gPanel.getTileL().getTileSet()[tileNum1L0].hasCollision() ||
                            gPanel.getTileL().getTileSet()[tileNum2L0].hasCollision() ||
                            gPanel.getTileL().getTileSet()[tileNum1L1].hasCollision() ||
                            gPanel.getTileL().getTileSet()[tileNum2L1].hasCollision()) {
                        entity.setCollision(true);
                    }
                }
                case ("SE") -> {
                    entityBottomBound = (entityBottom - entity.getVelocity()) / gPanel.getTileSize();
                    entityRightBound = (entityRight + entity.getVelocity()) / gPanel.getTileSize();
                    switch (gPanel.getTileL().getCurrentMap()) {
                        case ("OverWorld") -> {
                            tileNum1L0 = gPanel.getTileL().getMapArray().get(0)[entityRightBound][entityBottomBound];
                            tileNum1L1 = gPanel.getTileL().getMapArray().get(1)[entityRightBound][entityBottomBound];
                        }
                        case ("FireDungeon") -> {
                            tileNum1L0 = gPanel.getTileL().getMapArray().get(2)[entityRightBound][entityBottomBound];
                            tileNum1L1 = gPanel.getTileL().getMapArray().get(3)[entityRightBound][entityBottomBound];
                        }
//                        case ("WaterDungeon") -> {
//
//                        }
//                        case ("Wind Dungeon") -> {
//
//                        }
//                        case ("Earth Dungeon") -> {
//
//                        }
//                        case ("LightningDungeon") -> {
//
//                        }
//                        case ("DarkDungeon") -> {
//
//                        }
//                        case ("LightDungeon") -> {
//
//                        }
//                        case ("NatureDungeon") -> {
//
//                        }
//                        case ("MachinaDungeon") -> {
//
//                        }
                    }
                    if (gPanel.getTileL().getTileSet()[tileNum1L0].hasCollision() ||
                            gPanel.getTileL().getTileSet()[tileNum1L1].hasCollision()) {
                        entity.setCollision(true);
                    }
                }
                case ("NE") -> {
                    entityTopBound = (entityTop + entity.getVelocity()) / gPanel.getTileSize();
                    entityRightBound = (entityRight + entity.getVelocity()) / gPanel.getTileSize();
                    switch (gPanel.getTileL().getCurrentMap()) {
                        case ("OverWorld") -> {
                            tileNum1L0 = gPanel.getTileL().getMapArray().get(0)[entityRightBound][entityTopBound];
                            tileNum1L1 = gPanel.getTileL().getMapArray().get(1)[entityRightBound][entityTopBound];
                        }
                        case ("FireDungeon") -> {
                            tileNum1L0 = gPanel.getTileL().getMapArray().get(2)[entityRightBound][entityTopBound];
                            tileNum1L1 = gPanel.getTileL().getMapArray().get(3)[entityRightBound][entityTopBound];
                        }
//                        case ("WaterDungeon") -> {
//
//                        }
//                        case ("Wind Dungeon") -> {
//
//                        }
//                        case ("Earth Dungeon") -> {
//
//                        }
//                        case ("LightningDungeon") -> {
//
//                        }
//                        case ("DarkDungeon") -> {
//
//                        }
//                        case ("LightDungeon") -> {
//
//                        }
//                        case ("NatureDungeon") -> {
//
//                        }
//                        case ("MachinaDungeon") -> {
//
//                        }
                    }
                    if (gPanel.getTileL().getTileSet()[tileNum1L0].hasCollision() ||
                            gPanel.getTileL().getTileSet()[tileNum1L1].hasCollision()) {
                        entity.setCollision(true);

                    }
                }
                case ("SW") -> {
                    entityBottomBound = (entityBottom + entity.getVelocity()) / gPanel.getTileSize();
                    entityLeftBound = (entityLeft - entity.getVelocity()) / gPanel.getTileSize();
                    switch (gPanel.getTileL().getCurrentMap()) {
                        case ("OverWorld") -> {
                            tileNum1L0 = gPanel.getTileL().getMapArray().get(0)[entityLeftBound][entityBottomBound];
                            tileNum1L1 = gPanel.getTileL().getMapArray().get(1)[entityLeftBound][entityBottomBound];
                        }
                        case ("FireDungeon") -> {
                            tileNum1L0 = gPanel.getTileL().getMapArray().get(2)[entityLeftBound][entityBottomBound];
                            tileNum1L1 = gPanel.getTileL().getMapArray().get(3)[entityLeftBound][entityBottomBound];
                        }
//                        case ("WaterDungeon") -> {
//
//                        }
//                        case ("Wind Dungeon") -> {
//
//                        }
//                        case ("Earth Dungeon") -> {
//
//                        }
//                        case ("LightningDungeon") -> {
//
//                        }
//                        case ("DarkDungeon") -> {
//
//                        }
//                        case ("LightDungeon") -> {
//
//                        }
//                        case ("NatureDungeon") -> {
//
//                        }
//                        case ("MachinaDungeon") -> {
//
//                        }
                    }
                    if (gPanel.getTileL().getTileSet()[tileNum1L0].hasCollision() ||
                            gPanel.getTileL().getTileSet()[tileNum1L1].hasCollision()) {
                        entity.setCollision(true);
                    }
                }
                case ("NW") -> {
                    entityTopBound = (entityTop + entity.getVelocity()) / gPanel.getTileSize();
                    entityLeftBound = (entityLeft - entity.getVelocity()) / gPanel.getTileSize();
                    switch (gPanel.getTileL().getCurrentMap()) {
                        case ("OverWorld") -> {
                            tileNum1L0 = gPanel.getTileL().getMapArray().get(0)[entityLeftBound][entityTopBound];
                            tileNum1L1 = gPanel.getTileL().getMapArray().get(1)[entityLeftBound][entityTopBound];
                        }
                        case ("FireDungeon") -> {
                            tileNum1L0 = gPanel.getTileL().getMapArray().get(2)[entityLeftBound][entityTopBound];
                            tileNum1L1 = gPanel.getTileL().getMapArray().get(3)[entityLeftBound][entityTopBound];
                        }
//                        case ("WaterDungeon") -> {
//
//                        }
//                        case ("Wind Dungeon") -> {
//
//                        }
//                        case ("Earth Dungeon") -> {
//
//                        }
//                        case ("LightningDungeon") -> {
//
//                        }
//                        case ("DarkDungeon") -> {
//
//                        }
//                        case ("LightDungeon") -> {
//
//                        }
//                        case ("NatureDungeon") -> {
//
//                        }
//                        case ("MachinaDungeon") -> {
//
//                        }
                    }
                    if (gPanel.getTileL().getTileSet()[tileNum1L0].hasCollision() ||
                            gPanel.getTileL().getTileSet()[tileNum1L1].hasCollision()) {
                        entity.setCollision(true);
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException outOfBoundsException) {
            outOfBoundsException.getStackTrace();
            switch (gPanel.getTileL().getCurrentMap()){
                case ("OverWorld") -> {
                    entity.setWorldX(gPanel.getTileL().getMapArray().get(0)[15][15] * gPanel().getTileSize());
                    entity.setWorldY(gPanel.getTileL().getMapArray().get(0)[15][15] * gPanel().getTileSize());
                }
                case ("FireDungeon") -> {
                    entity.setWorldX(gPanel.getTileL().getMapArray().get(2)[15][15] * gPanel().getTileSize());
                    entity.setWorldY(gPanel.getTileL().getMapArray().get(2)[15][15] * gPanel().getTileSize());
                }
            }
        }
    }

    public int objectCollision (Entity entity, boolean player) {
        int index = 999;
        for (int i = 0; i < gPanel.getObjectL().getGameObjects().length ; i++) {
            if (gPanel.getObjectL().getGameObjects()[i] != null){
                entity.getHitBox().x = ((entity.getWorldX() - gPanel().getTileSize()) + entity.getHitBox().x);
                entity.getHitBox().y = ((entity.getWorldY() - gPanel().getTileSize()) + entity.getHitBox().y);

                gPanel.getObjectL().getGameObjects()[i].getHitBox().x = (gPanel.getObjectL().getGameObjects()[i].getWorldX() + gPanel.getObjectL().getGameObjects()[i].getHitBox().x);
                gPanel.getObjectL().getGameObjects()[i].getHitBox().y = (gPanel.getObjectL().getGameObjects()[i].getWorldY() + gPanel.getObjectL().getGameObjects()[i].getHitBox().y);

                switch (entity.getInput()) {
                    case ("up left"), ("up right") -> {
                        entity.getHitBox().y -= entity.getVelocity();
                        if(entity.getHitBox().intersects(gPanel.getObjectL().getGameObjects()[i].getHitBox())){
                            if (gPanel.getObjectL().getGameObjects()[i].hasCollision()){
                                entity.setCollision(true);
                            }
                            if (player) {
                                index = i;
                            }
                        }
                    }
                    case ("left") -> {
                        entity.getHitBox().x -= entity.getVelocity();
                        if(entity.getHitBox().intersects(gPanel.getObjectL().getGameObjects()[i].getHitBox())){
                            if (gPanel.getObjectL().getGameObjects()[i].hasCollision()){
                                entity.setCollision(true);
                            }
                            if (player) {
                                index = i;
                            }
                        }
                    }
                    case ("down left"), ("down right") -> {
                        entity.getHitBox().y += entity.getVelocity();
                        if(entity.getHitBox().intersects(gPanel.getObjectL().getGameObjects()[i].getHitBox())){
                            if (gPanel.getObjectL().getGameObjects()[i].hasCollision()){
                                entity.setCollision(true);
                            }
                            if (player) {
                                index = i;
                            }
                        }
                    }
                    case ("right") -> {
                        entity.getHitBox().x += entity.getVelocity();
                        if(entity.getHitBox().intersects(gPanel.getObjectL().getGameObjects()[i].getHitBox())){
                            if (gPanel.getObjectL().getGameObjects()[i].hasCollision()){
                                entity.setCollision(true);
                            }
                            if (player) {
                                index = i;
                            }
                        }
                    }
                    case ("SE") -> {
                        entity.getHitBox().x += entity.getVelocity();
                        entity.getHitBox().y += entity.getVelocity();
                        if(entity.getHitBox().intersects(gPanel.getObjectL().getGameObjects()[i].getHitBox())){
                            if (gPanel.getObjectL().getGameObjects()[i].hasCollision()){
                                entity.setCollision(true);
                            }
                            if (player) {
                                index = i;
                            }
                        }
                    }
                    case ("NE") -> {
                        entity.getHitBox().x += entity.getVelocity();
                        entity.getHitBox().y -= entity.getVelocity();
                        if(entity.getHitBox().intersects(gPanel.getObjectL().getGameObjects()[i].getHitBox())){
                            if (gPanel.getObjectL().getGameObjects()[i].hasCollision()){
                                entity.setCollision(true);
                            }
                            if (player) {
                                index = i;
                            }
                        }
                    }
                    case ("SW") -> {
                        entity.getHitBox().x -= entity.getVelocity();
                        entity.getHitBox().y += entity.getVelocity();
                        if(entity.getHitBox().intersects(gPanel.getObjectL().getGameObjects()[i].getHitBox())){
                            if (gPanel.getObjectL().getGameObjects()[i].hasCollision()){
                                entity.setCollision(true);
                            }
                            if (player) {
                                index = i;
                            }
                        }
                    }
                    case ("NW") -> {
                        entity.getHitBox().x -= entity.getVelocity();
                        entity.getHitBox().y -= entity.getVelocity();
                        if(entity.getHitBox().intersects(gPanel.getObjectL().getGameObjects()[i].getHitBox())){
                            if (gPanel.getObjectL().getGameObjects()[i].hasCollision()){
                                entity.setCollision(true);
                            }
                            if (player) {
                                index = i;
                            }
                        }
                    }
                }
                entity.getHitBox().x = entity.getHitBoxDefaultX();
                entity.getHitBox().y = entity.getHitBoxDefaultY();
                gPanel.getObjectL().getGameObjects()[i].getHitBox().x = gPanel.getObjectL().getGameObjects()[i].getHitBoxDefaultX();
                gPanel.getObjectL().getGameObjects()[i].getHitBox().y = gPanel.getObjectL().getGameObjects()[i].getHitBoxDefaultY();
            }
        }

        return (index);
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (EntityCollision) obj;
        return Objects.equals(this.gPanel, that.gPanel);
    }
    public int hashCode() {
        return Objects.hash(gPanel);
    }
    public String toString() {
        return "EntityCollision[" +
                "gPanel=" + gPanel + ']';
    }

}
