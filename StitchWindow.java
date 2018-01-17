package stitchCounter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StitchWindow
{
	RowReader pattern;
	private JFrame frmPatternKeeper;
	private JLabel lblStitch;
	private JPanel panel;
	private JLabel lblTitle;
	private JLabel lblDetails;
	private JPanel pnlUpload;
	private MyJButton btnUploadFile;
	private MyJButton btnPrev;
	private MyJButton btnNext;
	private JPanel pnlDisplay;
	private int pos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					StitchWindow window = new StitchWindow();
					window.frmPatternKeeper.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StitchWindow()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		RowReader pattern = new RowReader();
		pos = 0;
		frmPatternKeeper = new JFrame();
		frmPatternKeeper.setSize(new Dimension(480, 840));
		frmPatternKeeper.setResizable(false);
		frmPatternKeeper.setTitle("Pattern Keeper");
		frmPatternKeeper.setBounds(100, 100, 450, 300);
		frmPatternKeeper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPatternKeeper.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		panel = new JPanel();
		panel.setBackground(new Color(255, 0, 153));
		frmPatternKeeper.getContentPane().add(panel);
		frmPatternKeeper.setLocationRelativeTo(null);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		lblTitle = new JLabel("Pattern Keeper");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBackground(new Color(255, 0, 102));
		lblTitle.setFont(new Font("Cambria", Font.BOLD, 38));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTitle);

		pnlDisplay = new JPanel();
		pnlDisplay.setForeground(new Color(255, 255, 255));
		pnlDisplay.setBackground(new Color(0, 204, 255));
		frmPatternKeeper.getContentPane().add(pnlDisplay);
		pnlDisplay.setLayout(new GridLayout(1, 0, 0, 0));

		btnNext = new MyJButton("Next");
		btnNext.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				btnPrev.setEnabled(true);

				if ((pos + 1) <= (pattern.getRowsArr().get(0).getStsArr()
						.size()))
					pos++;

				lblStitch.setText(pattern.getRowsArr().get(0).getStsArr()
						.get(pos).getStrStitch());
				lblDetails.setText("Stitch "
						+ pattern.getRowsArr().get(0).getStsArr().get(pos)
								.getNumIntoCurrRow()
						+ " of "
						+ pattern.getRowsArr().get(0).getStsArr().size());
			}
		});  // end btnNext actionListener

		btnPrev = new MyJButton("Previous");
		btnPrev.setEnabled(false);
		btnPrev.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if ((pos - 1) >= 0)
				{
					pos--;
				}
				else
					btnPrev.setEnabled(false);

				lblStitch.setText(pattern.getRowsArr().get(0).getStsArr()
						.get(pos).getStrStitch());
				lblDetails.setText("Stitch "
						+ pattern.getRowsArr().get(0).getStsArr().get(pos)
								.getNumIntoCurrRow()
						+ " of "
						+ pattern.getRowsArr().get(0).getStsArr().size());
			}
		});  // end btnPrev actionListener

		lblStitch = new JLabel("Stitch");
		lblStitch.setFont(new Font("Cambria", Font.PLAIN, 48));
		lblStitch.setHorizontalAlignment(SwingConstants.CENTER);

		lblDetails = new JLabel("Stitch Details");
		lblDetails.setFont(new Font("Cambria", Font.PLAIN, 28));
		lblDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetails.setForeground(Color.white);
		// lblDetails.setText("Stitch " +
		// pattern.getRowsArr().get(0).getStsArr().get(0).getStrStitch());
		// + " of " + pattern.getRowsArr().get(0).getStsArr().size());
		pnlUpload = new JPanel();
		pnlUpload.setForeground(new Color(255, 255, 255));
		pnlUpload.setBackground(new Color(255, 0, 153));
		pnlUpload.setLayout(new GridLayout(1, 0, 0, 0));
		frmPatternKeeper.getContentPane().add(pnlUpload);

		btnUploadFile = new MyJButton("Upload File");
		btnUploadFile.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				pattern.readFile();

				pnlDisplay.add(btnPrev);
				pnlDisplay.add(lblStitch);
				pnlDisplay.add(btnNext);
				frmPatternKeeper.remove(pnlUpload);
				pnlUpload.remove(btnUploadFile);
				pnlUpload.add(lblDetails);
				frmPatternKeeper.getContentPane().add(pnlUpload);
				lblStitch.setText(pattern.getRowsArr().get(0).getStsArr()
						.get(pos).getStrStitch());
				btnPrev.setEnabled(false);

			}
		}); // end bthnUploadFile actionListener

		pnlUpload.add(btnUploadFile);

	} // initialize

	class MyJButton extends JButton
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		MyJButton(String text)
		{

			super();

			Font btnFont = new Font("Cambria", Font.PLAIN, 24);
			setFocusPainted(false);
			setBorder(null);
			setForeground(Color.white);
			if (isEnabled())
				setBackground(new Color(0, 0, 102));
			else
				setBackground(Color.white);

			setFont(btnFont);
			setText(text);
			addMouseListener(new MouseAdapter()
			{
				public void mouseEntered(java.awt.event.MouseEvent e)
				{
					JButton button = (JButton) e.getComponent();

					button.setBackground(new Color(0, 102, 204));
					// else
					// button.setBackground(new Color(0, 0, 0));
				}

				public void mouseExited(java.awt.event.MouseEvent e)
				{
					JButton button = (JButton) e.getComponent();
					button.setBackground(new Color(0, 0, 102));
				}
			}); // end btn mouseListener
		}
	}
}
