package vista_habitaciones;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import habitacion.TransferHabitacion;
import controlador.ControladorAplicacionImp;
import controlador.EventoNegocio;
import selector_vista.EventoVista;
import vista.Vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Daniel
 */
public class ModificarHabitacion extends javax.swing.JFrame implements Vista{

     
    static private ModificarHabitacion modificarHabitacion;

    /** Creates new form NuevoDepartamento */
    private ModificarHabitacion() {
        initComponents();
    }
   
    /**
     * Obtiene la instancia de la ventana
     * @return la instancia de la ventana
     */
    static public ModificarHabitacion obtenerInstancia(){
            if(modificarHabitacion == null){
                    modificarHabitacion = new ModificarHabitacion();
            }

            return modificarHabitacion;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campo_numhab = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        campo_nueva_capacidad = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Habitaci�n");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("N�mero Habitaci�n");

        campo_numhab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_numhabActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nueva Capacidad");

        campo_nueva_capacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo_nueva_capacidad, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(campo_numhab))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campo_numhab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(campo_nueva_capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        //Borra el los datos correspondiente al cerrar la ventana
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        		campo_numhab.setText("");
        		campo_nueva_capacidad.setText("");
            }
        });

		ImageIcon image = new ImageIcon("res/icono.png");

		this.setIconImage(image.getImage());
        
        pack();
    }// </editor-fold>                        

    private void campo_numhabActionPerformed(java.awt.event.ActionEvent evt) {                                             
    	realizarambios();
    }                                            

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                                     
    	realizarambios();
    }                                                    

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	realizarambios();
    }     
    
    private void realizarambios(){

 	   TransferHabitacion transferHabitacion = new TransferHabitacion();
 	   transferHabitacion.setCapacidad(Integer.valueOf(campo_nueva_capacidad.getText()).intValue());
 	   transferHabitacion.setNumero_hab(Integer.valueOf(this.campo_numhab.getText()).intValue());
 	   
        ControladorAplicacionImp.obtenerInstancia().accion(EventoNegocio.MODIFICAR_HABITACI�N, transferHabitacion);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModificarHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarHabitacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel2;
    private javax.swing.JFormattedTextField campo_numhab;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField campo_nueva_capacidad;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   

	@Override
	public void actualizar(int id_evento_vista, Object datos) {
		//Borra lo anterior
		campo_numhab.setText("");
		campo_nueva_capacidad.setText("");
		
		if(id_evento_vista == EventoVista.MODIFICAR_HABITACION_EXITO){
			JOptionPane.showMessageDialog(null, "Se ha modificado la habitaci�n con �xito", "Modificar Habitaci�n", JOptionPane.INFORMATION_MESSAGE);		
		}	
		else if(id_evento_vista == EventoVista.MODIFICAR_HABITACION_NO_EXISTE){
			JOptionPane.showMessageDialog(null, "ERROR!! La habitaci�n que se desea modificar no existe", "Modificar Habitaci�n", JOptionPane.ERROR_MESSAGE);
		}
		else if (id_evento_vista == EventoVista.MODIFICAR_HABITACION_CAPACIDAD_MENOR_OCUPANTES){
			JOptionPane.showMessageDialog(null, "ERROR!! La nueva capacidad debe ser mayor que el n�mero de ocupantes", "Modificar Habitaci�n", JOptionPane.ERROR_MESSAGE);
		}
		else if (id_evento_vista == EventoVista.MODIFICAR_HABITACION_FALLO){
			JOptionPane.showMessageDialog(null, "ERROR!! Ha ocurrido un error con la BD", "Modificar Habitaci�n", JOptionPane.ERROR_MESSAGE);
		}
	}
}
