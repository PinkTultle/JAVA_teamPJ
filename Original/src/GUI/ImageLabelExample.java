package GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import JDBC.ItemDAO;

public class ImageLabelExample extends JFrame{
	private JLabel imageLabel;
	public ImageLabelExample() {
        super("Image Label Example");

        // UI 초기화
        imageLabel = new JLabel();
        add(imageLabel);

        // 이미지 파일 경로에 맞게 수정
        String imagePath = "src/images/Persian_Smile.jpg";

        ItemDAO itemDAO = new ItemDAO();
		// 이미지를 JLabel에 표시
        itemDAO.displayImage(imagePath, imageLabel);

        // JFrame 설정
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

	public static void main(String[] args) throws IOException {
		SwingUtilities.invokeLater(() -> new ImageLabelExample());
	}

}
