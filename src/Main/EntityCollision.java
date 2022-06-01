package Main;

import Entity.Entity;

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
        int tileNum1L0, tileNum2L0, tileNum1L1, tileNum2L1;
        switch (entity.getDirection()) {
            case ("up left"), ("up right"), ("NE"), ("NW") -> {
                entityTopBound = (entityTop - entity.getVelocity()) / gPanel.getTileSize();
                tileNum1L0 = gPanel.getTileL().getMapArray().get(0)[entityLeftBound][entityTopBound];
                tileNum2L0 = gPanel.getTileL().getMapArray().get(0)[entityRightBound][entityTopBound];
                tileNum1L1 = gPanel.getTileL().getMapArray().get(1)[entityLeftBound][entityTopBound];
                tileNum2L1 = gPanel.getTileL().getMapArray().get(1)[entityRightBound][entityTopBound];
                if (gPanel.getTileL().getTileSet()[tileNum1L0].hasCollision() ||
                        gPanel.getTileL().getTileSet()[tileNum2L0].hasCollision() ||
                        gPanel.getTileL().getTileSet()[tileNum1L1].hasCollision() ||
                        gPanel.getTileL().getTileSet()[tileNum2L1].hasCollision()) {
                    entity.setCollision(true);
                    entity.setWorldY(entity.getWorldY() + 1);
                }
            }
            case ("left") -> {
                entityLeftBound = (entityLeft - entity.getVelocity()) / gPanel.getTileSize();
                tileNum1L0 = gPanel.getTileL().getMapArray().get(0)[entityLeftBound][entityTopBound];
                tileNum2L0 = gPanel.getTileL().getMapArray().get(0)[entityLeftBound][entityBottomBound];
                tileNum1L1 = gPanel.getTileL().getMapArray().get(1)[entityLeftBound][entityTopBound];
                tileNum2L1 = gPanel.getTileL().getMapArray().get(1)[entityLeftBound][entityBottomBound];
                if (gPanel.getTileL().getTileSet()[tileNum1L0].hasCollision() ||
                        gPanel.getTileL().getTileSet()[tileNum2L0].hasCollision() ||
                        gPanel.getTileL().getTileSet()[tileNum1L1].hasCollision() ||
                        gPanel.getTileL().getTileSet()[tileNum2L1].hasCollision()) {
                    entity.setCollision(true);
                    entity.setWorldX(entity.getWorldX() + 1);
                }
            }
            case ("down left"), ("down right"), ("SE"), ("SW") -> {
                entityBottomBound = (entityBottom + entity.getVelocity()) / gPanel.getTileSize();
                tileNum1L0 = gPanel.getTileL().getMapArray().get(0)[entityLeftBound][entityBottomBound];
                tileNum2L0 = gPanel.getTileL().getMapArray().get(0)[entityRightBound][entityBottomBound];
                tileNum1L1 = gPanel.getTileL().getMapArray().get(1)[entityLeftBound][entityBottomBound];
                tileNum2L1 = gPanel.getTileL().getMapArray().get(1)[entityRightBound][entityBottomBound];
                if (gPanel.getTileL().getTileSet()[tileNum1L0].hasCollision() ||
                        gPanel.getTileL().getTileSet()[tileNum2L0].hasCollision() ||
                        gPanel.getTileL().getTileSet()[tileNum1L1].hasCollision() ||
                        gPanel.getTileL().getTileSet()[tileNum2L1].hasCollision()) {
                    entity.setCollision(true);
                    entity.setWorldY(entity.getWorldY() - 1);
                }
            }
            case ("right") -> {
                entityRightBound = (entityRight + entity.getVelocity()) / gPanel.getTileSize();
                tileNum1L0 = gPanel.getTileL().getMapArray().get(0)[entityRightBound][entityTopBound];
                tileNum2L0 = gPanel.getTileL().getMapArray().get(0)[entityRightBound][entityBottomBound];
                tileNum1L1 = gPanel.getTileL().getMapArray().get(1)[entityRightBound][entityTopBound];
                tileNum2L1 = gPanel.getTileL().getMapArray().get(1)[entityRightBound][entityBottomBound];
                if (gPanel.getTileL().getTileSet()[tileNum1L0].hasCollision() ||
                        gPanel.getTileL().getTileSet()[tileNum2L0].hasCollision() ||
                        gPanel.getTileL().getTileSet()[tileNum1L1].hasCollision() ||
                        gPanel.getTileL().getTileSet()[tileNum2L1].hasCollision()) {
                    entity.setCollision(true);
                    entity.setWorldX(entity.getWorldX() - 1);
                }
            }
        }
    }
}
