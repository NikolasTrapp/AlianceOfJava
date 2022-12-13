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


public class ViewIniciaRpg extends JFrame {
public static int indice = 0;
public static Personagem personagem;
String ataqueSelecionado;

//Lista de personagens pré cadastrados
public static ArrayList<Personagem> personagens = new ArrayList<>(Arrays.asList(
        new Personagem(320, "Monge", 10, 12),
        new Personagem(315, "Ladino", 13, 12),
        new Personagem(330, "Guerreiro", 12, 12),
        new Personagem(340, "Barbaro", 15, 12),
        new Personagem(305, "Mago", 8, 12),
        new Personagem(305, "Clérigo", 7, 12),
        new Personagem(310, "Bardo", 9, 12)
));

//Lista de inimigos que será gerada ao decorrer do jogo
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
		
		int inimigoSelecionado = 1;

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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

		
		JLabel lblHp = new JLabel("Hp:");
		lblHp.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHp.setBounds(91, 80, 52, 23);
		
		JLabel lblMp = new JLabel("Mp:");
		lblMp.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMp.setBounds(225, 80, 42, 23);
		
		JButton btnPersonagemAnterior = new JButton("<---");

		btnPersonagemAnterior.setBounds(0, 65, 67, 38);
		
		JButton btnProximoPersonagem = new JButton("--->");

		btnProximoPersonagem.setBounds(397, 65, 67, 38);
		
		
		JLabel lblNomeP = new JLabel("NomeP");
		lblNomeP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeP.setBounds(149, 50, 226, 23);
		
		JLabel lblHpP = new JLabel("Hp");
		lblHpP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHpP.setBounds(149, 80, 73, 23);
		
		JPanel TelaCombateMobs = new JPanel();
		TelaCombateMobs.setBounds(0, 0, 531, 478);
		contentPane.add(TelaCombateMobs);
		TelaCombateMobs.setLayout(null);
		
		JLabel lblImgPersonagem = new JLabel("Img Personagem");
		lblImgPersonagem.setBounds(0, 220, 126, 195);
		TelaCombateMobs.add(lblImgPersonagem);
		
		JLabel lblImgInimigo = new JLabel("img Inimigo1");
		lblImgInimigo.setBounds(10, 11, 103, 147);
		TelaCombateMobs.add(lblImgInimigo);
		
		JLabel lblImgInimigo2 = new JLabel("img Inimigo2");
		lblImgInimigo2.setBounds(123, 11, 103, 147);
		TelaCombateMobs.add(lblImgInimigo2);
		
		JLabel lblImgInimigo3 = new JLabel("img Inimigo3");
		lblImgInimigo3.setBounds(236, 11, 103, 147);
		TelaCombateMobs.add(lblImgInimigo3);
		
		JLabel lblImgInimigo4 = new JLabel("img Inimigo4");
		lblImgInimigo4.setBounds(349, 11, 103, 147);
		TelaCombateMobs.add(lblImgInimigo4);
		
		JLabel lblHpInimigo1L = new JLabel("hp:");
		lblHpInimigo1L.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHpInimigo1L.setBounds(10, 159, 36, 32);
		TelaCombateMobs.add(lblHpInimigo1L);
		
		JLabel lblHpInimigo1 = new JLabel("10");
		lblHpInimigo1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHpInimigo1.setBounds(42, 159, 42, 32);
		TelaCombateMobs.add(lblHpInimigo1);
		
		JLabel lblHpInimigo2L = new JLabel("hp:");
		lblHpInimigo2L.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHpInimigo2L.setBounds(123, 159, 36, 32);
		TelaCombateMobs.add(lblHpInimigo2L);
		
		JLabel lblHpInimigo2 = new JLabel("10");
		lblHpInimigo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHpInimigo2.setBounds(155, 159, 42, 32);
		TelaCombateMobs.add(lblHpInimigo2);
		
		JLabel lblHpInimigo3L = new JLabel("hp:");
		lblHpInimigo3L.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHpInimigo3L.setBounds(236, 159, 36, 32);
		TelaCombateMobs.add(lblHpInimigo3L);
		
		JLabel lblHpInimigo3 = new JLabel("10");
		lblHpInimigo3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHpInimigo3.setBounds(268, 159, 42, 32);
		TelaCombateMobs.add(lblHpInimigo3);
		
		JLabel lblHpInimigo4L = new JLabel("hp:");
		lblHpInimigo4L.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHpInimigo4L.setBounds(349, 159, 36, 32);
		TelaCombateMobs.add(lblHpInimigo4L);
		
		JLabel lblHpInimigo4 = new JLabel("10");
		lblHpInimigo4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHpInimigo4.setBounds(381, 159, 42, 32);
		TelaCombateMobs.add(lblHpInimigo4);
		
		
		JRadioButton rdbtnNomeInimigo1 = new JRadioButton("Nome Inimigo1");
		rdbtnNomeInimigo1.setName("1");
		rdbtnNomeInimigo1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNomeInimigo1.setBounds(4, 198, 109, 23);
		TelaCombateMobs.add(rdbtnNomeInimigo1);
		
		JRadioButton rdbtnNomeInimigo2 = new JRadioButton("Nome Inimigo2");
		rdbtnNomeInimigo2.setName("2");
		rdbtnNomeInimigo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNomeInimigo2.setBounds(123, 198, 109, 23);
		TelaCombateMobs.add(rdbtnNomeInimigo2);
		
		JRadioButton rdbtnNomeInimigo3 = new JRadioButton("Nome Inimigo3");
		rdbtnNomeInimigo3.setName("3");
		rdbtnNomeInimigo3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNomeInimigo3.setBounds(236, 198, 109, 23);
		TelaCombateMobs.add(rdbtnNomeInimigo3);
		
		JRadioButton rdbtnNomeInimigo4 = new JRadioButton("Nome Inimigo4");
		rdbtnNomeInimigo4.setName("4");
		rdbtnNomeInimigo4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNomeInimigo4.setBounds(349, 198, 109, 23);
		TelaCombateMobs.add(rdbtnNomeInimigo4);
		
		ButtonGroup rdbtinimigos = new ButtonGroup();
		rdbtinimigos.add(rdbtnNomeInimigo1);
		rdbtinimigos.add(rdbtnNomeInimigo2);
		rdbtinimigos.add(rdbtnNomeInimigo3);
		rdbtinimigos.add(rdbtnNomeInimigo4);
		
		JLabel lblAtq1 = new JLabel("ATQ1");
		lblAtq1.setName("1");
		lblAtq1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblAtq1.setBounds(136, 277, 133, 32);
		TelaCombateMobs.add(lblAtq1);
		
		JLabel lblAaaaa = new JLabel("aaaaa");
		lblAaaaa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAaaaa.setBounds(381, 228, 83, 32);
		TelaCombateMobs.add(lblAaaaa);
		
		JLabel lblAtq3 = new JLabel("ATQ3");
		lblAtq3.setName("3");
		lblAtq3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAtq3.setBounds(136, 307, 133, 32);
		TelaCombateMobs.add(lblAtq3);
		
		JLabel lblAtq4 = new JLabel("ATQ4");
		lblAtq4.setName("4");
		lblAtq4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAtq4.setBounds(308, 307, 144, 32);
		TelaCombateMobs.add(lblAtq4);
		
		JLabel lblAtq2 = new JLabel("ATQ2");
		lblAtq2.setName("2");
		lblAtq2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAtq2.setBounds(307, 277, 145, 32);
		TelaCombateMobs.add(lblAtq2);
		
		JLabel lblAtaqueEscolhido = new JLabel("Ataque Escolhido:");
		lblAtaqueEscolhido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAtaqueEscolhido.setBounds(268, 228, 111, 32);
		TelaCombateMobs.add(lblAtaqueEscolhido);
		
		JButton button = new JButton("Atacar");
		button.setBounds(42, 359, 184, 74);
		TelaCombateMobs.add(button);
		
		JTextArea textAreaHistoricoBatalha = new JTextArea();
		textAreaHistoricoBatalha.setEditable(false);
		textAreaHistoricoBatalha.setBounds(268, 350, 253, 117);
		TelaCombateMobs.add(textAreaHistoricoBatalha);
		
		JLabel lblMpP = new JLabel("Mp");
		lblMpP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMpP.setBounds(277, 80, 56, 23);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(ViewIniciaRpg.class.getResource("/img/mago.gif")));
		lblImg.setBounds(91, 116, 284, 139);
		

		JLabel lblFundostatus = new JLabel("");
		lblFundostatus.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblFundostatus.setBounds(77, 11, 310, 257);
		
		JPanel TelaEscolhaPersonagem = new JPanel();
		TelaEscolhaPersonagem.setBounds(0, 0, 531, 478);
		contentPane.add(TelaEscolhaPersonagem);
		TelaEscolhaPersonagem.setLayout(null);
		TelaEscolhaPersonagem.add(lblFundostatus);
		TelaEscolhaPersonagem.add(lblClasse);
		TelaEscolhaPersonagem.add(lblClasseP);
		TelaEscolhaPersonagem.add(lblNome);
		TelaEscolhaPersonagem.add(lblNomeP);
		TelaEscolhaPersonagem.add(lblHp);
		TelaEscolhaPersonagem.add(lblHpP);
		TelaEscolhaPersonagem.add(lblMp);
		TelaEscolhaPersonagem.add(lblMpP);
		TelaEscolhaPersonagem.add(lblImg);
		TelaEscolhaPersonagem.add(btnProximoPersonagem);
		TelaEscolhaPersonagem.add(btnPersonagemAnterior);
		TelaEscolhaPersonagem.add(btnInicar);
		
		JPanel TelaCombateBoss = new JPanel();
		TelaCombateBoss.setBounds(0, 0, 531, 478);
		contentPane.add(TelaCombateBoss);
		
		btnPersonagemAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(indice > 0){
					indice--;
				}else{
					indice = personagens.size() - 1;
				}
				carregarPersonagem(lblClasseP, lblNomeP, lblHpP, lblMpP);
			}
		});
		
		btnProximoPersonagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(indice < 5){
				indice++;

				}else{
					indice = 0;
				}
				carregarPersonagem(lblClasseP, lblNomeP, lblHpP, lblMpP);
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
				carregarInimigos(rdbtnNomeInimigo1, rdbtnNomeInimigo2, rdbtnNomeInimigo3, rdbtnNomeInimigo4, lblHpInimigo1, lblHpInimigo2, lblHpInimigo3, lblHpInimigo4);
				
			}
		});
		

		lblAtq1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblAtq2.setBorder(null);
				lblAtq3.setBorder(null);
				lblAtq4.setBorder(null);
				lblAtq1.setBorder(new LineBorder(Color.RED, 3, true));
				
				ataqueSelecionado = lblAtq1.getText();
				
				lblAaaaa.setText(lblAtq1.getText());
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
				
				lblAaaaa.setText(lblAtq2.getText());
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
				lblAaaaa.setText(lblAtq3.getText());
				
				
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
				
				lblAaaaa.setText(lblAtq4.getText());
			}
		});
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if ((ataqueSelecionado != null) && (rdbtinimigos.getSelection() != null)){

					System.out.println(getSelectedButtonText(rdbtinimigos));
					System.out.println(ataqueSelecionado);
				} else {
					
				}

			}
		});
		
		TelaCombateBoss.setVisible(false);
		TelaCombateMobs.setVisible(false);
		
		carregarPersonagem(lblClasseP, lblNomeP, lblHpP, lblMpP);
	}
	
	
	public void carregarPersonagem(JLabel lblNomePersonagem, JLabel lblNomeP, JLabel lblHpP, JLabel lblMpP){
		
		
		
		Personagem p = personagens.get(indice);
		
		lblNomePersonagem.setText(p.getNome());
		
		lblNomeP.setText("Nome do personagem");
		
		lblHpP.setText(String.valueOf(p.getHpBase()));
		
		lblMpP.setText(String.valueOf(p.getMpBase()));
		
	}
	
	   public static void gerarInimigos(int levelPersonagem){
	        /**
	         * Esta função cria os inimigos e adiciona-os na lista principal de inimigos.
	         *
	         * @param levelPersonagem O level atual do personagem.
	         */
		   int multiplicador = 1;
	    	for (int i = 0; i < 4; i++){
	    		int n = getRandom(1, 5);
	    		if (n == 1) inimigos.add(new Inimigo("Lobo", 50 * (levelPersonagem+1)*multiplicador,(int) Math.floor(3 + (levelPersonagem)* multiplicador),levelPersonagem*multiplicador));
	    		else if (n == 2) inimigos.add(new Inimigo("Goblin", 55 * (levelPersonagem+1)*multiplicador,(int) Math.floor(3 + (levelPersonagem)* multiplicador),levelPersonagem*multiplicador));
	    		else if (n == 3) inimigos.add(new Inimigo("Troll", 60 * (levelPersonagem+1)*multiplicador,(int) Math.floor(3 + (levelPersonagem)* multiplicador),levelPersonagem*multiplicador));
	    		else if (n == 4) inimigos.add(new Inimigo("Zumbi", 65 * (levelPersonagem+1)*multiplicador,(int) Math.floor(3 + (levelPersonagem)* multiplicador),levelPersonagem*multiplicador));
	    		else if (n == 5) inimigos.add(new Inimigo("Urso", 70 * (levelPersonagem+1)*multiplicador,(int) Math.floor(3 + (levelPersonagem)* multiplicador),levelPersonagem*multiplicador));
	    		else throw new NoSuchElementException("Ocorreu um erro ao criar um inimigo!");
	    	}

	    }

	    public static int getRandom(int min, int max){
	        /**
	         * Esta função retorna um nímero aleatório com base no numero minimo
	         * e no numero máximo informados.
	         *
	         * @param min Numero minimo.
	         * @param max Numero máximo.
	         *
	         * @return O numero sorteado.
	         */

	        return (int)Math.floor(Math.random()*(max-min+1)+min);
	    }

	   
	    public static boolean iniciarRodada(JTextArea textAreaHistoricoBatalha, int inimigoSelecionado){
	        /**
	         * Esta função controla uma unica onda de inimigos, ela gera os inimigos a
	         * partir do nivel de xp do personagem, e logo em seguida ela controla o combate
	         * pedindo ao usuário o ataque que ele deseja desferir e fazendo os inimigos
	         * atacarem ele, além de verificar se todos os inimigos possuem algum efeito.
	         */
	        gerarInimigos(personagem.getLevel()); //Gerar inimigos
	        int turno = 1; //Numero do turno atual
	        
	        	textAreaHistoricoBatalha.append("Turno: " + turno);
	        	textAreaHistoricoBatalha.append("Sua vez de atacar!");

	            textAreaHistoricoBatalha.append("Qual inimigo deseja atacar: ");

	            //Chamando a função de ataque do personagem e desferindo o dano retornado ao inimigo

	            int danoAtaque = personagem.atacar(inimigos.get(inimigoSelecionado));
	            inimigos.get(inimigoSelecionado).tomarDano(danoAtaque);

	            textAreaHistoricoBatalha.append("Você desferiu uma quantidade de "+danoAtaque+" de dano ao "+inimigos.get(inimigoSelecionado).getNome());
	            matarInimigo(inimigos.get(inimigoSelecionado)); //Verificar se o inimigo morreu

	            //Turno dos inimigos
	            textAreaHistoricoBatalha.append("Vez dos inimigos!");
	            for (Inimigo inimigo : inimigos){
	                verificarSeInimigoMorreu(inimigo); //Verificar se o inimigo possui um efeito e se vai morrer
	                //Atacar o personagem
	                int dano = personagem.tomarDano(inimigo.atacar(personagem));
	                textAreaHistoricoBatalha.append("O inimigo " + inimigo.getNome() +
	                        " desferiu a você uma quantidade de " + dano +
	                        " de dano, lhe resta " + personagem.getHp() + " pontos de vida");
	            }
	            turno ++;
	            if (personagem.getHp() <= 0) return true;
	        return false;
	    }
	    
	    public static void verificarSeInimigoMorreu(Inimigo inimigo){
	        /**
	         * Esta função tem o papel de verificar se o inimigo vai morrer
	         * para o seu efeito (Caso ele possua algum).
	         *
	         * @param inimimo O inimigo para verificar se vai morrer para o efeito.
	         */
	        inimigo.tomarDano(inimigo.validarDanoEfeito());
	        matarInimigo(inimigo);
	    }

	    public static void matarInimigo(Inimigo inimigo){
	        /**
	         * Esta função tem o papel de verificar se o inimigo morreu.
	         *
	         * @param inimigo O inimigo para verificar se está morto.
	         */
	        if (inimigo.getHp() <= 0){
	            inimigos.remove(inimigo);
	            System.out.println("Inimigo morto!");
	            personagem.addXp(inimigo.getXpDrop());
	        }
	    }
	    
		public void carregarInimigos(JRadioButton rdbtnNomeInimigo1, JRadioButton rdbtnNomeInimigo2, JRadioButton rdbtnNomeInimigo3, JRadioButton rdbtnNomeInimigo4, JLabel lblHpInimigo1, JLabel lblHpInimigo2, JLabel lblHpInimigo3, JLabel lblHpInimigo4){
			
			if (inimigos.size() == 4) {
				
				rdbtnNomeInimigo1.setText(inimigos.get(0).getNome());
				rdbtnNomeInimigo2.setText(inimigos.get(1).getNome());
				rdbtnNomeInimigo3.setText(inimigos.get(2).getNome());
				rdbtnNomeInimigo4.setText(inimigos.get(3).getNome());
				
				lblHpInimigo1.setText(String.valueOf(inimigos.get(0).getHp()));
				lblHpInimigo2.setText(String.valueOf(inimigos.get(1).getHp()));
				lblHpInimigo3.setText(String.valueOf(inimigos.get(2).getHp()));
				lblHpInimigo4.setText(String.valueOf(inimigos.get(3).getHp()));
				
				
			} else if(inimigos.size() == 3){
				rdbtnNomeInimigo1.setText(inimigos.get(0).getNome());
				rdbtnNomeInimigo2.setText(inimigos.get(1).getNome());
				rdbtnNomeInimigo3.setText(inimigos.get(2).getNome());
				
				lblHpInimigo1.setText(String.valueOf(inimigos.get(0).getHp()));
				lblHpInimigo2.setText(String.valueOf(inimigos.get(1).getHp()));
				lblHpInimigo3.setText(String.valueOf(inimigos.get(2).getHp()));

			}else if(inimigos.size() == 2){
				rdbtnNomeInimigo1.setText(inimigos.get(0).getNome());
				rdbtnNomeInimigo2.setText(inimigos.get(1).getNome());
				
				lblHpInimigo1.setText(String.valueOf(inimigos.get(0).getHp()));
				lblHpInimigo2.setText(String.valueOf(inimigos.get(1).getHp()));

			} else if(inimigos.size() == 1){
				rdbtnNomeInimigo1.setText(inimigos.get(0).getNome());
				
				lblHpInimigo1.setText(String.valueOf(inimigos.get(0).getHp()));

			}

		}
		
		public void carregarAtaques(JLabel lblAtq1, JLabel lblAtq2, JLabel lblAtq3, JLabel lblAtq4){
			
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
