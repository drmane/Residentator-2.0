/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista_empleados;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import controlador.ControladorAplicacionImp;
import controlador.EventoNegocio;
import empleado.Empleado;
import selector_vista.EventoVista;
import tarea.Tarea;
import vista.Vista;

/**
 *
 * @author Ricardo
 */
public class AsignarTarea extends javax.swing.JFrame implements Vista{

	static private AsignarTarea asignarTarea;
	
	
	
    public AsignarTarea() {
        initComponents();
    }

	static public AsignarTarea obtenerInstancia(){
		if(asignarTarea == null){
			asignarTarea = new AsignarTarea();
		}
		
		return asignarTarea;
	}
	
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	
    	this.setTitle("Asignar Tarea");

        jPanel1 = new javax.swing.JPanel();
        labelIDEmpleado = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        campoIDEmpleado = new javax.swing.JTextField();
        labelIDTarea = new javax.swing.JLabel();
        campoIDTarea = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelIDEmpleado.setText("ID Empleado");

        jButton1.setText("Asignar");
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
         	   botonAceptarActionPerformed(evt);
            }
        });

      
        labelIDTarea.setText("ID Tarea");



        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelIDEmpleado)
                            .addComponent(labelIDTarea))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoIDTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoIDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoIDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIDEmpleado))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIDTarea)
                    .addComponent(campoIDTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

		ImageIcon image = new ImageIcon("res/icono.png");

		this.setIconImage(image.getImage());
        
        pack();
    }// </editor-fold>                        

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
 	   
    		//Se crean empleado y tarea para pasarlas al controlador
    	
    		Tarea tarea = new Tarea();
    		Empleado empleado = new Empleado();
    		
    		//Se guardan los campos de id empleado y tarea
    		empleado.setId(Integer.valueOf(campoIDEmpleado.getText()));		 		
    		tarea.setId(Integer.valueOf(campoIDTarea.getText()));
    		
    		
    		//a�adir el empleado con id a la lista de tareas para recuperarlo
    		tarea.getLista_empleados().add(empleado);
    	
    	
    		ControladorAplicacionImp.obtenerInstancia().accion(EventoNegocio.ASIGNAR_TAREA, tarea);
    		
    		
    	
 	 
        
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
            java.util.logging.Logger.getLogger(AsignarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsignarTarea().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JTextField campoIDEmpleado;
    private javax.swing.JTextField campoIDTarea;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelIDEmpleado;
    private javax.swing.JLabel labelIDTarea;
    // End of variables declaration                   



	@Override
	public void actualizar(int id_evento_vista, Object datos) {
		  if(id_evento_vista == EventoVista.ASIGNAR_TAREA_EXITO){
				JOptionPane.showMessageDialog(null, "Se ha asignado con �xito la tarea con id " + (int)datos + " al empleado", "Asignar Tarea", JOptionPane.INFORMATION_MESSAGE);
		   }
		   else if(id_evento_vista == EventoVista.ASIGNAR_TAREA_FALLO_EMPLEADO_NO_EXISTE){
				JOptionPane.showMessageDialog(null, "ERROR!! El empleado no existe", "Asignar Tarea", JOptionPane.ERROR_MESSAGE);
		   }
		   else if(id_evento_vista == EventoVista.ASIGNAR_TAREA_FALLO_TAREA_NO_EXISTE){
			   JOptionPane.showMessageDialog(null, "ERROR!! La tarea no existe", "Asignar Tarea", JOptionPane.ERROR_MESSAGE);
		   }
		   else if(id_evento_vista == EventoVista.ASIGNAR_TAREA_FALLO_TAREA_YA_ASIGNADA_EMPLEADO){
			   JOptionPane.showMessageDialog(null, "ERROR!! La tarea ya est� asignada al empleado", "Asignar Tarea", JOptionPane.ERROR_MESSAGE);
		   }
		   else if(id_evento_vista == EventoVista.ASIGNAR_TAREA_FALLO_EMPLEADO_YA_ASIGNADO_TAREA){
			   JOptionPane.showMessageDialog(null, "ERROR!! El empleado ya est� asignado a la tarea", "Asignar Tarea", JOptionPane.ERROR_MESSAGE);
		   }
		   
		
	}
}
