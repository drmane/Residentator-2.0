package vista_facturas;

import factura.TransferFactura;
import habitacion.TransferHabitacion;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import selector_vista.EventoVista;
import vista.Vista;
import controlador.ControladorAplicacionImp;
import controlador.EventoNegocio;

/**
 *
 * @author Daniel
 */
public class MostrarFacturas extends javax.swing.JFrame implements Vista{

    static private MostrarFacturas mostrarFacturas;
	
    private MostrarFacturas(){
            initComponents();
    }

    static public MostrarFacturas obtenerInstancia(){
            if(mostrarFacturas == null){
                    mostrarFacturas = new MostrarFacturas();
            }

            return mostrarFacturas;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrar Facturas");
        setResizable(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        jTextArea1.setEditable(false);
        
        //Borra el los datos correspondiente al cerrar la ventana
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            	jTextArea1.setText("");
            }
        });
        
		ImageIcon image = new ImageIcon("res/icono.png");

		this.setIconImage(image.getImage());

        pack();
    }// </editor-fold>                        

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
            java.util.logging.Logger.getLogger(MostrarFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarFacturas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration 
    
    //Permite mostrar las habitaciones por pantalla
    public void mostrar(){
    	ControladorAplicacionImp.obtenerInstancia().accion(EventoNegocio.MOSTRAR_FACTURAS, null);
    }

	@Override
	public void actualizar(int id_evento_vista, Object datos) {
		if(id_evento_vista == EventoVista.MOSTRAR_FACTURAS_EXITO){
			List<TransferFactura> lista_facturas = (List)datos;
			
			//Ordena la lista para mostrar las habitaciones ordenadas
			Collections.sort(lista_facturas, new Comparator<TransferFactura>(){
			    @Override
			    public int compare(TransferFactura t1, TransferFactura t2) {
			    	return t1.getId() - t2.getId();
			    }
			});
	
			jTextArea1.append("  ID\tFecha\t                             Cuota    \n\n");
			
			String f;
			
			for(TransferFactura t: lista_facturas){

				StringBuilder sb = new StringBuilder(t.getFecha());
				
				sb.delete(15, 22);
				
				jTextArea1.append("  " + t.getId() +"\t" + sb.toString()  + "\t" + t.getCutoa() + "\n"); 
			}
			
		}
		else if(id_evento_vista == EventoVista.MOSTRAR_FACTURAS_FALLO){
			JOptionPane.showMessageDialog(null, "ERROR!! No se han encontrado facturas para mostrar", "Mostrar Facturas", JOptionPane.ERROR_MESSAGE);
		}
	}
}
