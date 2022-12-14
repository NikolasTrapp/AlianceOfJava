package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import entidades.Chefao;
import entidades.Inimigo;
import entidades.Personagem;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ViewIniciaRpg extends JFrame {
	public static int indice = 0;
	public static Personagem personagem;
	public String ataqueSelecionado;
	int inimigoSelecionado = 0;
	int turno = 1; // Numero do turno atual
	ButtonGroup rdbtinimigos = new ButtonGroup();

	// Lista de personagens pré cadastrados
	public static ArrayList<Personagem> personagens = new ArrayList<>(
			Arrays.asList(new Personagem(320, "Monge", 10, 12), new Personagem(315, "Ladino", 13, 12),
					new Personagem(330, "Guerreiro", 12, 12), new Personagem(340, "Barbaro", 15, 12),
					new Personagem(305, "Mago", 8, 20), new Personagem(305, "Clérigo", 7, 12),
					new Personagem(310, "Bardo", 9, 12)));

	// Lista de inimigos que será gerada ao decorrer do jogo
	public static ArrayList<Inimigo> inimigos = new ArrayList<>();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewIniciaRpg frame = new ViewIniciaRpg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewIniciaRpg() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel TelaCombateMobs = new JPanel();
		TelaCombateMobs.setBounds(0, 0, 584, 478);
		contentPane.add(TelaCombateMobs);
		TelaCombateMobs.setLayout(null);

		JLabel lblImgPersonagem = new JLabel("Img Personagem");
		lblImgPersonagem.setBounds(0, 301, 160, 177);
		TelaCombateMobs.add(lblImgPersonagem);

		JLabel lblImgInimigo1 = new JLabel("img Inimigo1");
		lblImgInimigo1.setBounds(10, 11, 135, 147);
		TelaCombateMobs.add(lblImgInimigo1);

		JLabel lblImgInimigo2 = new JLabel("img Inimigo2");
		lblImgInimigo2.setBounds(149, 11, 135, 147);
		TelaCombateMobs.add(lblImgInimigo2);

		JLabel lblImgInimigo3 = new JLabel("img Inimigo3");
		lblImgInimigo3.setBounds(294, 11, 135, 147);
		TelaCombateMobs.add(lblImgInimigo3);

		JLabel lblImgInimigo4 = new JLabel("img Inimigo4");
		lblImgInimigo4.setBounds(439, 11, 135, 147);
		TelaCombateMobs.add(lblImgInimigo4);

		JLabel imgHpInimigoLuta1 = new JLabel("");
		imgHpInimigoLuta1.setIcon(new ImageIcon(ViewIniciaRpg.class.getResource("/img/hp.png")));
		imgHpInimigoLuta1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		imgHpInimigoLuta1.setBounds(6, 159, 36, 32);
		TelaCombateMobs.add(imgHpInimigoLuta1);

		JLabel lblHpInimigo1 = new JLabel("10");
		lblHpInimigo1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHpInimigo1.setBounds(42, 159, 42, 32);
		TelaCombateMobs.add(lblHpInimigo1);

		JLabel imgHpInimigoLuta2 = new JLabel("");
		imgHpInimigoLuta2.setIcon(new ImageIcon(ViewIniciaRpg.class.getResource("/img/hp.png")));
		imgHpInimigoLuta2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		imgHpInimigoLuta2.setBounds(149, 159, 36, 32);
		TelaCombateMobs.add(imgHpInimigoLuta2);

		JLabel lblHpInimigo2 = new JLabel("10");
		lblHpInimigo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHpInimigo2.setBounds(181, 159, 42, 32);
		TelaCombateMobs.add(lblHpInimigo2);

		JLabel imgHpInimigoLuta3 = new JLabel("");
		imgHpInimigoLuta3.setIcon(new ImageIcon(ViewIniciaRpg.class.getResource("/img/hp.png")));
		imgHpInimigoLuta3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		imgHpInimigoLuta3.setBounds(294, 159, 36, 32);
		TelaCombateMobs.add(imgHpInimigoLuta3);

		JLabel lblHpInimigo3 = new JLabel("10");
		lblHpInimigo3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHpInimigo3.setBounds(326, 159, 42, 32);
		TelaCombateMobs.add(lblHpInimigo3);

		JLabel imgHpInimigoLuta4 = new JLabel("");
		imgHpInimigoLuta4.setIcon(new ImageIcon(ViewIniciaRpg.class.getResource("/img/hp.png")));
		imgHpInimigoLuta4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		imgHpInimigoLuta4.setBounds(439, 159, 36, 32);
		TelaCombateMobs.add(imgHpInimigoLuta4);

		JLabel lblHpInimigo4 = new JLabel("10");
		lblHpInimigo4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHpInimigo4.setBounds(471, 159, 42, 32);
		TelaCombateMobs.add(lblHpInimigo4);

		JRadioButton rdbtnNomeInimigo1 = new JRadioButton("Nome Inimigo1");
		rdbtnNomeInimigo1.setName("1");
		rdbtnNomeInimigo1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNomeInimigo1.setBounds(10, 198, 109, 23);
		TelaCombateMobs.add(rdbtnNomeInimigo1);

		JRadioButton rdbtnNomeInimigo2 = new JRadioButton("Nome Inimigo2");
		rdbtnNomeInimigo2.setName("2");
		rdbtnNomeInimigo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNomeInimigo2.setBounds(149, 198, 109, 23);
		TelaCombateMobs.add(rdbtnNomeInimigo2);

		JRadioButton rdbtnNomeInimigo3 = new JRadioButton("Nome Inimigo3");
		rdbtnNomeInimigo3.setName("3");
		rdbtnNomeInimigo3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNomeInimigo3.setBounds(294, 198, 109, 23);
		TelaCombateMobs.add(rdbtnNomeInimigo3);

		JRadioButton rdbtnNomeInimigo4 = new JRadioButton("Nome Inimigo4");
		rdbtnNomeInimigo4.setName("4");
		rdbtnNomeInimigo4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNomeInimigo4.setBounds(439, 198, 109, 23);
		TelaCombateMobs.add(rdbtnNomeInimigo4);
		rdbtinimigos.add(rdbtnNomeInimigo1);
		rdbtinimigos.add(rdbtnNomeInimigo2);
		rdbtinimigos.add(rdbtnNomeInimigo3);
		rdbtinimigos.add(rdbtnNomeInimigo4);

		JLabel lblAtq1 = new JLabel("ATQ1");
		lblAtq1.setName("1");
		lblAtq1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblAtq1.setBounds(10, 238, 133, 32);
		TelaCombateMobs.add(lblAtq1);

		JLabel lblAtq = new JLabel("");
		lblAtq.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAtq.setBounds(449, 228, 135, 32);
		TelaCombateMobs.add(lblAtq);

		JLabel lblAtq3 = new JLabel("ATQ3");
		lblAtq3.setName("3");
		lblAtq3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAtq3.setBounds(10, 268, 133, 32);
		TelaCombateMobs.add(lblAtq3);

		JLabel lblAtq4 = new JLabel("ATQ4");
		lblAtq4.setName("4");
		lblAtq4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAtq4.setBounds(182, 268, 144, 32);
		TelaCombateMobs.add(lblAtq4);

		JLabel lblAtq2 = new JLabel("ATQ2");
		lblAtq2.setName("2");
		lblAtq2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAtq2.setBounds(181, 238, 145, 32);
		TelaCombateMobs.add(lblAtq2);

		JLabel lblAtaqueEscolhido = new JLabel("Ataque Escolhido:");
		lblAtaqueEscolhido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAtaqueEscolhido.setBounds(326, 228, 125, 32);
		TelaCombateMobs.add(lblAtaqueEscolhido);

		JButton btnAtacarMob = new JButton("");
		btnAtacarMob.setContentAreaFilled(false);
		btnAtacarMob.setFocusable(false);
		btnAtacarMob.setIgnoreRepaint(true);
		btnAtacarMob.setRequestFocusEnabled(false);
		btnAtacarMob.setOpaque(false);
		btnAtacarMob.setIcon(new ImageIcon(ViewIniciaRpg.class.getResource("/img/atacar.png")));
		btnAtacarMob.setBounds(349, 255, 133, 84);
		TelaCombateMobs.add(btnAtacarMob);

		JTextArea textAreaHistoricoBatalha = new JTextArea();
		textAreaHistoricoBatalha.setEditable(false);
		JScrollPane scroll = new JScrollPane(textAreaHistoricoBatalha);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(268, 350, 306, 117);
		TelaCombateMobs.add(scroll);
		

		JLabel imgHpPersonagemLuta = new JLabel("");
		imgHpPersonagemLuta.setIcon(new ImageIcon(ViewIniciaRpg.class.getResource("/img/hp.png")));
		imgHpPersonagemLuta.setBounds(170, 312, 36, 27);
		TelaCombateMobs.add(imgHpPersonagemLuta);

		JLabel lblHpPersonagemLuta = new JLabel("10");
		lblHpPersonagemLuta.setBounds(211, 311, 36, 32);
		TelaCombateMobs.add(lblHpPersonagemLuta);

		JLabel imgAtaquePersonagemLuta = new JLabel("a");
		imgAtaquePersonagemLuta.setIcon(new ImageIcon(ViewIniciaRpg.class.getResource("/img/dano.png")));
		imgAtaquePersonagemLuta.setBounds(170, 350, 36, 35);
		TelaCombateMobs.add(imgAtaquePersonagemLuta);

		JLabel lblAtaquePersonagemLuta = new JLabel("10");
		lblAtaquePersonagemLuta.setBounds(211, 346, 36, 32);
		TelaCombateMobs.add(lblAtaquePersonagemLuta);

		JLabel imgMpPersonagemLuta = new JLabel("");
		imgMpPersonagemLuta.setIcon(new ImageIcon(ViewIniciaRpg.class.getResource("/img/mp.png")));
		imgMpPersonagemLuta.setBounds(170, 389, 36, 32);
		TelaCombateMobs.add(imgMpPersonagemLuta);

		JLabel lblMpPersonagemLuta = new JLabel("10");
		lblMpPersonagemLuta.setBounds(211, 389, 36, 32);
		TelaCombateMobs.add(lblMpPersonagemLuta);

		TelaCombateMobs.setVisible(false);

		JButton btnInicar = new JButton("Iniciar Rpg");
		btnInicar.setBounds(191, 299, 142, 45);

		JLabel lblClasse = new JLabel("Classe:");
		lblClasse.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClasse.setBounds(91, 24, 67, 23);

		JLabel lblClasseP = new JLabel("Nome Personagem");
		lblClasseP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClasseP.setBounds(149, 24, 226, 23);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(91, 50, 67, 23);

		JLabel lblHp = new JLabel("");
		lblHp.setIcon(new ImageIcon(ViewIniciaRpg.class.getResource("/img/hp.png")));
		lblHp.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHp.setBounds(91, 80, 52, 31);

		JLabel lblMp = new JLabel("");
		lblMp.setIcon(new ImageIcon(ViewIniciaRpg.class.getResource("/img/mp.png")));
		lblMp.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMp.setBounds(225, 80, 42, 31);

		JButton btnPersonagemAnterior = new JButton("");
		btnPersonagemAnterior.setIcon(new ImageIcon(ViewIniciaRpg.class.getResource("/img/ArroyP2.png")));
		btnPersonagemAnterior.setContentAreaFilled(false);

		btnPersonagemAnterior.setBounds(0, 65, 67, 38);

		JButton btnProximoPersonagem = new JButton("");
		btnProximoPersonagem.setContentAreaFilled(false);
		btnProximoPersonagem.setIcon(new ImageIcon(ViewIniciaRpg.class.getResource("/img/ArroyP1.png")));

		btnProximoPersonagem.setBounds(458, 65, 67, 38);

		JLabel lblNomeP = new JLabel("NomeP");
		lblNomeP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeP.setBounds(149, 50, 226, 23);

		JLabel lblHpP = new JLabel("Hp");
		lblHpP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHpP.setBounds(149, 80, 73, 31);

		JLabel lblMpP = new JLabel("Mp");
		lblMpP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMpP.setBounds(277, 80, 42, 31);

		JLabel lblImgP = new JLabel("");
		lblImgP.setIcon(new ImageIcon(ViewIniciaRpg.class.getResource("/img/mago.gif")));
		lblImgP.setBounds(91, 116, 350, 139);

		JPanel TelaEscolhaPersonagem = new JPanel();
		TelaEscolhaPersonagem.setBounds(0, 0, 584, 478);
		contentPane.add(TelaEscolhaPersonagem);
		TelaEscolhaPersonagem.setLayout(null);
		TelaEscolhaPersonagem.add(lblClasse);
		TelaEscolhaPersonagem.add(lblClasseP);
		TelaEscolhaPersonagem.add(lblNome);
		TelaEscolhaPersonagem.add(lblNomeP);
		TelaEscolhaPersonagem.add(lblHp);
		TelaEscolhaPersonagem.add(lblHpP);
		TelaEscolhaPersonagem.add(lblMp);
		TelaEscolhaPersonagem.add(lblMpP);
		TelaEscolhaPersonagem.add(lblImgP);
		TelaEscolhaPersonagem.add(btnProximoPersonagem);
		TelaEscolhaPersonagem.add(btnPersonagemAnterior);
		TelaEscolhaPersonagem.add(btnInicar);

		JLabel lblDano = new JLabel("");
		lblDano.setIcon(new ImageIcon(ViewIniciaRpg.class.getResource("/img/dano.png")));
		lblDano.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDano.setBounds(327, 80, 48, 31);
		TelaEscolhaPersonagem.add(lblDano);

		JLabel lblDanoP = new JLabel("12");
		lblDanoP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDanoP.setBounds(379, 80, 62, 31);
		TelaEscolhaPersonagem.add(lblDanoP);

		JLabel lblFundostatus = new JLabel("");
		lblFundostatus.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblFundostatus.setBounds(77, 11, 364, 257);
		TelaEscolhaPersonagem.add(lblFundostatus);

		carregarPersonagem(lblClasseP, lblNomeP, lblHpP, lblMpP, lblDanoP);

		JPanel TelaCombateBoss = new JPanel();
		TelaCombateBoss.setBounds(0, 0, 584, 478);
		contentPane.add(TelaCombateBoss);

		TelaCombateBoss.setVisible(false);

		// ------ AÇÃO DOS BOTÕES ------
		
		lblAtq1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				lblAtq2.setBorder(null);
				lblAtq3.setBorder(null);
				lblAtq4.setBorder(null);
				lblAtq1.setBorder(new LineBorder(Color.RED, 3, true));

				ataqueSelecionado = lblAtq1.getText();

				lblAtq.setText(lblAtq1.getText());
			}
		});

		lblAtq2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				lblAtq1.setBorder(null);
				lblAtq3.setBorder(null);
				lblAtq4.setBorder(null);
				lblAtq2.setBorder(new LineBorder(Color.RED, 3, true));

				ataqueSelecionado = lblAtq2.getText();

				lblAtq.setText(lblAtq2.getText());
			}
		});

		lblAtq3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				lblAtq2.setBorder(null);
				lblAtq1.setBorder(null);
				lblAtq4.setBorder(null);
				lblAtq3.setBorder(new LineBorder(Color.RED, 3, true));

				ataqueSelecionado = lblAtq3.getText();
				lblAtq.setText(lblAtq3.getText());

			}
		});

		lblAtq4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				lblAtq2.setBorder(null);
				lblAtq3.setBorder(null);
				lblAtq1.setBorder(null);
				lblAtq4.setBorder(new LineBorder(Color.RED, 3, true));

				ataqueSelecionado = lblAtq4.getText();

				lblAtq.setText(lblAtq4.getText());
			}
		});

		btnAtacarMob.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if ((ataqueSelecionado != null) && (rdbtinimigos.getSelection() != null)) {

					boolean errado = true;
					if ((rdbtnNomeInimigo1.isSelected()) && (rdbtnNomeInimigo1.isVisible())) {
						inimigoSelecionado = 0;
					} else if (rdbtnNomeInimigo2.isSelected() && (rdbtnNomeInimigo2.isVisible())) {
						inimigoSelecionado = 1;
					} else if (rdbtnNomeInimigo3.isSelected() && (rdbtnNomeInimigo3.isVisible())) {
						inimigoSelecionado = 2;
					} else if (rdbtnNomeInimigo4.isSelected() && (rdbtnNomeInimigo4.isVisible())) {
						inimigoSelecionado = 3;
					} else {
						JOptionPane.showMessageDialog(null, "Selecione um inimigo e um ataque!");
						errado = false;
					}

					if (errado) {
						atacarInimigo(textAreaHistoricoBatalha, inimigoSelecionado, turno);

						atualizaPersonagemLuta(lblHpPersonagemLuta, lblAtaquePersonagemLuta, lblMpPersonagemLuta);

						atualizarInimigo(rdbtnNomeInimigo1, rdbtnNomeInimigo2, rdbtnNomeInimigo3, rdbtnNomeInimigo4,
								lblHpInimigo1, lblHpInimigo2, lblHpInimigo3, lblHpInimigo4, imgHpInimigoLuta1,
								imgHpInimigoLuta2, imgHpInimigoLuta3, imgHpInimigoLuta4, lblImgInimigo1, lblImgInimigo2,
								lblImgInimigo3, lblImgInimigo4);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um inimigo e um ataque!");
				}

			}
		});

		btnPersonagemAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (indice > 0) {
					indice--;
				} else {
					indice = personagens.size() - 1;
				}
				carregarPersonagem(lblClasseP, lblNomeP, lblHpP, lblMpP, lblDanoP);
			}
		});

		btnProximoPersonagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (indice < 5) {
					indice++;

				} else {
					indice = 0;
				}
				carregarPersonagem(lblClasseP, lblNomeP, lblHpP, lblMpP, lblDanoP);
			}
		});

		btnInicar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				personagem = personagens.get(indice);

				TelaEscolhaPersonagem.setVisible(false);
				TelaCombateMobs.setVisible(true);

				gerarInimigos(1);
				carregarAtaques(lblAtq1, lblAtq2, lblAtq3, lblAtq4);
				carregarInimigos(rdbtnNomeInimigo1, rdbtnNomeInimigo2, rdbtnNomeInimigo3, rdbtnNomeInimigo4,
						lblHpInimigo1, lblHpInimigo2, lblHpInimigo3, lblHpInimigo4);
				atualizaPersonagemLuta(lblHpPersonagemLuta, lblAtaquePersonagemLuta, lblMpPersonagemLuta);
			}
		});

	}

	// ---- METODOS ----

	public void carregarPersonagem(JLabel lblNomePersonagem, JLabel lblNomeP, JLabel lblHpP, JLabel lblMpP,
			JLabel lblDanoP) {

		Personagem p = personagens.get(indice);

		lblNomePersonagem.setText(p.getNome());

		lblNomeP.setText("Nome do personagem");

		lblHpP.setText(String.valueOf(p.getHpBase()));

		lblMpP.setText(String.valueOf(p.getMpBase()));

		lblDanoP.setText(String.valueOf(p.getDanoBase()));

	}

	public void atualizaPersonagemLuta(JLabel lblHpPersonagemLuta, JLabel lblAtaquePersonagemLuta,
			JLabel lblMpPersonagemLuta) {

		Personagem p = personagens.get(indice);

		lblHpPersonagemLuta.setText(String.valueOf(p.getHp()));

		lblMpPersonagemLuta.setText(String.valueOf(p.getMp()));

		lblAtaquePersonagemLuta.setText(String.valueOf(p.getDano()));

	}

	public static void gerarInimigos(int levelPersonagem) {
		/**
		 * Esta função cria os inimigos e adiciona-os na lista principal de
		 * inimigos.
		 *
		 * @param levelPersonagem
		 *            O level atual do personagem.
		 */
		int multiplicador = 1;
		for (int i = 0; i < 4; i++) {
			int n = getRandom(1, 5);
			if (n == 1)
				inimigos.add(new Inimigo("Lobo", 50 * (levelPersonagem + 1) * multiplicador,
						(int) Math.floor(3 + (levelPersonagem) * multiplicador), levelPersonagem * multiplicador));
			else if (n == 2)
				inimigos.add(new Inimigo("Goblin", 55 * (levelPersonagem + 1) * multiplicador,
						(int) Math.floor(3 + (levelPersonagem) * multiplicador), levelPersonagem * multiplicador));
			else if (n == 3)
				inimigos.add(new Inimigo("Troll", 60 * (levelPersonagem + 1) * multiplicador,
						(int) Math.floor(3 + (levelPersonagem) * multiplicador), levelPersonagem * multiplicador));
			else if (n == 4)
				inimigos.add(new Inimigo("Zumbi", 65 * (levelPersonagem + 1) * multiplicador,
						(int) Math.floor(3 + (levelPersonagem) * multiplicador), levelPersonagem * multiplicador));
			else if (n == 5)
				inimigos.add(new Inimigo("Urso", 70 * (levelPersonagem + 1) * multiplicador,
						(int) Math.floor(3 + (levelPersonagem) * multiplicador), levelPersonagem * multiplicador));
			else
				throw new NoSuchElementException("Ocorreu um erro ao criar um inimigo!");
		}

	}

	public static int getRandom(int min, int max) {
		/**
		 * Esta função retorna um nímero aleatório com base no numero minimo e
		 * no numero máximo informados.
		 *
		 * @param min
		 *            Numero minimo.
		 * @param max
		 *            Numero máximo.
		 *
		 * @return O numero sorteado.
		 */

		return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}

	public static void iniciarRodada(JTextArea textAreaHistoricoBatalha, int turno) {
		/**
		 * Esta função controla uma unica onda de inimigos, ela gera os inimigos
		 * a partir do nivel de xp do personagem, e logo em seguida ela controla
		 * o combate pedindo ao usuário o ataque que ele deseja desferir e
		 * fazendo os inimigos atacarem ele, além de verificar se todos os
		 * inimigos possuem algum efeito.
		 */

		String texto = "";
		gerarInimigos(personagem.getLevel()); // Gerar inimigos

		texto += "\nTurno: " + turno;
		texto += "\nSua vez de atacar!";

		texto += "\nEscolha o inimigo que deseja atacar e o ataque que deseja utilizar: ";

		textAreaHistoricoBatalha.append(texto);
	}

	public static boolean atacarInimigo(JTextArea textAreaHistoricoBatalha, int inimigoSelecionado, int turno) {

		// Chamando a função de ataque do personagem e desferindo o dano
		// retornado ao inimigo

		String texto = "";

		int danoAtaque = personagem.atacar(inimigos.get(inimigoSelecionado));
		inimigos.get(inimigoSelecionado).tomarDano(danoAtaque);

		texto += "\n\nVocê causou " + danoAtaque + " de dano ao " + inimigos.get(inimigoSelecionado).getNome();
		matarInimigo(inimigos.get(inimigoSelecionado)); // Verificar se o
														// inimigo morreu

		// Turno dos inimigos
		textAreaHistoricoBatalha.append("\nVez dos inimigos!");
		for (Inimigo inimigo : inimigos) {
			verificarSeInimigoMorreu(inimigo); // Verificar se o inimigo possui
												// um efeito e se vai morrer
			// Atacar o personagem
			int dano = personagem.tomarDano(inimigo.atacar(personagem));
			texto += "\nO " + inimigo.getNome() + " causou a você " + dano + " de dano";
		}

		textAreaHistoricoBatalha.append(texto);
		turno++;
		if (personagem.getHp() <= 0)
			return true;
		return false;

	}

	public static void verificarSeInimigoMorreu(Inimigo inimigo) {
		/**
		 * Esta função tem o papel de verificar se o inimigo vai morrer para o
		 * seu efeito (Caso ele possua algum).
		 *
		 * @param inimimo
		 *            O inimigo para verificar se vai morrer para o efeito.
		 */
		inimigo.tomarDano(inimigo.validarDanoEfeito());
		matarInimigo(inimigo);
	}

	public static void matarInimigo(Inimigo inimigo) {
		/**
		 * Esta função tem o papel de verificar se o inimigo morreu.
		 *
		 * @param inimigo
		 *            O inimigo para verificar se está morto.
		 */
		if (inimigo.getHp() <= 0) {
			inimigos.remove(inimigo);
			System.out.println("Inimigo morto!");
			personagem.addXp(inimigo.getXpDrop());
		}
	}

	public void carregarInimigos(JRadioButton rdbtnNomeInimigo1, JRadioButton rdbtnNomeInimigo2,
			JRadioButton rdbtnNomeInimigo3, JRadioButton rdbtnNomeInimigo4, JLabel lblHpInimigo1, JLabel lblHpInimigo2,
			JLabel lblHpInimigo3, JLabel lblHpInimigo4) {

		if (inimigos.size() == 4) {

			rdbtnNomeInimigo1.setText(inimigos.get(0).getNome());
			rdbtnNomeInimigo2.setText(inimigos.get(1).getNome());
			rdbtnNomeInimigo3.setText(inimigos.get(2).getNome());
			rdbtnNomeInimigo4.setText(inimigos.get(3).getNome());

			lblHpInimigo1.setText(String.valueOf(inimigos.get(0).getHp()));
			lblHpInimigo2.setText(String.valueOf(inimigos.get(1).getHp()));
			lblHpInimigo3.setText(String.valueOf(inimigos.get(2).getHp()));
			lblHpInimigo4.setText(String.valueOf(inimigos.get(3).getHp()));

		}
	}

	public void atualizarInimigo(JRadioButton rdbtnNomeInimigo1, JRadioButton rdbtnNomeInimigo2,
			JRadioButton rdbtnNomeInimigo3, JRadioButton rdbtnNomeInimigo4, JLabel lblHpInimigo1, JLabel lblHpInimigo2,
			JLabel lblHpInimigo3, JLabel lblHpInimigo4, JLabel imgHpInimigoLuta1, JLabel imgHpInimigoLuta2,
			JLabel imgHpInimigoLuta3, JLabel imgHpInimigoLuta4, JLabel lblImgInimigo1, JLabel lblImgInimigo2,
			JLabel lblImgInimigo3, JLabel lblImgInimigo4) {

		if (inimigos.size() == 4) {

			lblHpInimigo1.setText(String.valueOf(inimigos.get(0).getHp()));
			lblHpInimigo2.setText(String.valueOf(inimigos.get(1).getHp()));
			lblHpInimigo3.setText(String.valueOf(inimigos.get(2).getHp()));
			lblHpInimigo4.setText(String.valueOf(inimigos.get(3).getHp()));

		} else if (inimigos.size() == 3) {
			rdbtnNomeInimigo1.setText(inimigos.get(0).getNome());
			rdbtnNomeInimigo2.setText(inimigos.get(1).getNome());
			rdbtnNomeInimigo3.setText(inimigos.get(2).getNome());
			rdbtnNomeInimigo4.setVisible(false);

			lblHpInimigo1.setText(String.valueOf(inimigos.get(0).getHp()));
			lblHpInimigo2.setText(String.valueOf(inimigos.get(1).getHp()));
			lblHpInimigo3.setText(String.valueOf(inimigos.get(2).getHp()));
			lblHpInimigo4.setVisible(false);

			imgHpInimigoLuta4.setVisible(false);
			lblImgInimigo4.setVisible(false);

		} else if (inimigos.size() == 2) {
			rdbtnNomeInimigo1.setText(inimigos.get(0).getNome());
			rdbtnNomeInimigo2.setText(inimigos.get(1).getNome());
			rdbtnNomeInimigo3.setVisible(false);
			rdbtnNomeInimigo4.setVisible(false);

			lblHpInimigo1.setText(String.valueOf(inimigos.get(0).getHp()));
			lblHpInimigo2.setText(String.valueOf(inimigos.get(1).getHp()));
			lblHpInimigo3.setVisible(false);
			lblHpInimigo4.setVisible(false);

			imgHpInimigoLuta3.setVisible(false);
			imgHpInimigoLuta4.setVisible(false);

			lblImgInimigo3.setVisible(false);
			lblImgInimigo4.setVisible(false);

		} else if (inimigos.size() == 1) {
			rdbtnNomeInimigo1.setText(inimigos.get(0).getNome());
			rdbtnNomeInimigo2.setVisible(false);
			rdbtnNomeInimigo3.setVisible(false);
			rdbtnNomeInimigo4.setVisible(false);

			lblHpInimigo1.setText(String.valueOf(inimigos.get(0).getHp()));
			lblHpInimigo2.setVisible(false);
			lblHpInimigo3.setVisible(false);
			lblHpInimigo4.setVisible(false);

			imgHpInimigoLuta2.setVisible(false);
			imgHpInimigoLuta3.setVisible(false);
			imgHpInimigoLuta4.setVisible(false);

			lblImgInimigo2.setVisible(false);
			lblImgInimigo3.setVisible(false);
			lblImgInimigo4.setVisible(false);
		}

	}

	public void carregarAtaques(JLabel lblAtq1, JLabel lblAtq2, JLabel lblAtq3, JLabel lblAtq4) {

		lblAtq1.setText(personagem.getAtaques().get(0).getNome());
		lblAtq2.setText(personagem.getAtaques().get(1).getNome());
		lblAtq3.setText(personagem.getAtaques().get(2).getNome());
		lblAtq4.setText(personagem.getAtaques().get(3).getNome());

	}

	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getName();
			}
		}

		return null;
	}
}
