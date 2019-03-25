/******************************************************
 Cours:   LOG121
 Session: H2017
 Groupe:  01
 Projet: Laboratoire #4
 Étudiant(e)s: Louis-Simon McNicoll, Olivier Nadeau, Mikaël Sauriol et Christelle Sissoko

 Nom du fichier: Serializer.java
 Date créé: 2017-03-25
 Date dern. modif. 2017-xx-0xx
 *******************************************************
 Historique des modifications
 *******************************************************
 2017-03-25 Version Initiale -
 *******************************************************/
package model;

import controller.PerspectiveController;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

/**
 * Cette classe permet de Serialiser une liste d'ImagePerspective
 */
public final class Serializer {

    /**
     * Cette méthode permet d'enregistrer les perspectives et l'image en les sérialisant
     *
     * @param images la liste de perspectives à sérialiser
     */
    public static Boolean saveToFile(ArrayList<ImagePerspective> images) {
        Vector2D tabVector[] = new Vector2D[images.size()];
        double tabZoomLevel[] = new double[images.size()];
        byte[] byteArrayImage = null;

        for (int i = 0; i < images.size(); i++) {
            tabVector[i] = images.get(i).getVector2D();
            tabZoomLevel[i] = images.get(i).getZoomLevel();
        }

        try {
            ByteArrayOutputStream imageByte = new ByteArrayOutputStream();
            ImageIO.write(images.get(0).getBufferedImage(), "png", imageByte);
            byteArrayImage = imageByte.toByteArray();
        } catch (Exception e) {
            System.err.println("Error: " + e);
            return false; // is this necessary ?
        }
        SavingModel sm = new SavingModel(byteArrayImage, tabVector, tabZoomLevel);
        try {
            FileOutputStream out = new FileOutputStream("perspectiveFile.ps");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(sm);
            oos.close();
        } catch (Exception e) {
            System.err.println("Problem serializing: " + e);
            return false;
        }
        return true;
    }

    /**
     * Cette méthode permet de charger une image et une perspective enregistrée
     * prédédemment.
     *
     * @param file le fichier d'où charger l'image et les perspectives
     * @param perspectiveController Le controlleur où envoyer les perspectives
     * chargées
     */
    public static void loadFromFile(File file, PerspectiveController perspectiveController){
        try {
            String filePath = file.getAbsolutePath();
            if(filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length()).equals("ps")) {
                FileInputStream inFile = new FileInputStream(file);
                ObjectInputStream buffer = new ObjectInputStream(inFile);

                SavingModel model = (SavingModel) buffer.readObject();
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(model.imageBytes));
                Vector2D[] tabVectors = model.tabVector;
                double[] tabZoomLevel = model.tabZoomLevel;
                buffer.close();
                perspectiveController.loadSavedPerspectives(img, tabVectors, tabZoomLevel);
            }
            else {
                JOptionPane.showMessageDialog(null,"Erreur lors l'ouverture du fichier. " +
                        "Extension necessaire: '.ps'","Telecharement",JOptionPane.ERROR_MESSAGE);
            }

        }
        catch(Exception ex){
            System.err.println("Problem deserializing: " + ex);
        }
    }
}
