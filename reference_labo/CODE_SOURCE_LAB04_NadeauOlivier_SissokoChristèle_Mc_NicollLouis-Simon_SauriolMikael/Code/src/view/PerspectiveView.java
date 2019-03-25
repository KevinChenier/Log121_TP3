/**
 * ****************************************************
 * Cours:   LOG121
 * Session: H2017
 * Groupe:  01
 * Projet: Laboratoire #4
 * Étudiant(e)s: Louis-Simon McNicoll, Olivier Nadeau, Mikaël Sauriol et Christelle Sissoko
 *
 * Nom du fichier: PerspectiveView.java
 * Date créé: 2017-03-25
 * Date dern. modif. 2017-xx-0xx
 *******************************************************
 * Historique des modifications
 *******************************************************
 * 2017-03-25 Version Initiale -
 *
 ******************************************************
 */
package view;

import controller.PerspectiveController;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;
import model.ImagePerspective;
import model.ModelObservable;
import model.ModelObserver;
import model.Vector2D;

/**
 * Affiche une image modifiée selon une translation et un niveau de zoom
 */
class PerspectiveView extends JPanel implements ModelObserver {

    private static final int MINIMUM_HEIGHT_AND_WIDTH = 1;

    /**
     * Pourcentage de l'espace disponible qui devrait être occupé par l'image
     */
    private final double occupiedWidthRatio;
    /**
     * Le label contant l'image
     */
    private final JLabel lblImage = new JLabel();

    /**
     * Constructeur de PerspectiveView
     *
     * @param idPerspective Indentifie la perspective associée à cette vue
     * @param occupiedWidthRation Pourcentage de l'espace disponible qui devrait
     * être occupé par l'image
     * @param perspectiveController Le contrôleur des perspectives
     */
    PerspectiveView(int idPerspective, double occupiedWidthRation,
            PerspectiveController perspectiveController) {
        this.occupiedWidthRatio = occupiedWidthRation;
        this.setLayout(null);
        this.add(lblImage);

        this.addMouseWheelListener(e -> {
            perspectiveController.zoom(idPerspective, -e.getWheelRotation());
        });

        this.addMouseListener(new MouseAdapter() {
            /**
             * Le point inital lors d'un "click and drag"
             */
            private Vector2D initialPoint;

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                initialPoint = new Vector2D(e.getPoint().x, e.getPoint().y);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                Vector2D finalPoint = new Vector2D(e.getPoint().x, e.getPoint().y);
                perspectiveController.translate(idPerspective,
                        initialPoint.addVector(finalPoint.getOpposite())
                        .getOpposite());
            }
        });
    }

    /**
     * Appelée lorsque l'état du model associé à cette vue change
     * 
     * @param modelObservable Le model dont l'état a changé
     */
    @Override
    public void update(ModelObservable modelObservable) {
        setZoom(modelObservable);
    }

    /**
     * Cette méthode permet d'appliquer les changements suite à une tranlation
     *
     * @param srcImg L'image à afficher
     * @param w La largeur de l'image
     * @param h La hauteur de l'image
     * @param translatedX La translation en X
     * @param translatedY La translation en Y
     * @return L'image modifiée sous forme d'Icon
     */
    private Icon resize(Image srcImg, int w, int h, int translatedX, int translatedY) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, translatedX, translatedY, w, h, null);
        g2.dispose();

        return new ImageIcon(resizedImg);
    }

    /**
     * Applique le niveau de zoom à l'image.
     *
     * @param modelObservable Le model observé ayant besoin d'être redessinné
     */
    private void setZoom(ModelObservable modelObservable) {
        ImagePerspective imagePerspective = (ImagePerspective) modelObservable;

        double zoomLevel = imagePerspective.getZoomLevel();
        BufferedImage img = imagePerspective.getBufferedImage();
        Vector2D finalTranslation = imagePerspective.getVector2D();

        if (zoomLevel < 0) {
            zoomLevel = 1 / Math.abs(zoomLevel);
        } else if (zoomLevel == 0) {
            zoomLevel = 1;
        }
        int imageWidth = Math.max((int) (this.getWidth() * occupiedWidthRatio
                * zoomLevel), MINIMUM_HEIGHT_AND_WIDTH);
        int imageHeight = Math.max((int) (this.getHeight() * zoomLevel),
                MINIMUM_HEIGHT_AND_WIDTH);
        lblImage.setIcon(resize(img, imageWidth, imageHeight,
                finalTranslation.getX(), finalTranslation.getY()));
        lblImage.setSize(imageWidth, imageHeight);
        lblImage.setLocation(this.getWidth() / 2 - imageWidth / 2,
                this.getHeight() / 2 - imageHeight / 2);
        lblImage.invalidate();
        this.repaint();
    }
}
