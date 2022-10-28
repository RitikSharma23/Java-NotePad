import javax.swing.*;
import javax.swing.plaf.MenuItemUI;
import java.io.*; 
import org.w3c.dom.Text;
import java.awt.*;
import java.awt.event.*;
import java.rmi.StubNotFoundException;
 

class ActionEventDemo implements ActionListener {

    JFrame jf=new JFrame();
    File file;
    JButton edit,view;
    JTextArea a;
    JMenu menu,menu2,menu3,sub;
    JMenuItem neww,nw,open,save,savea,page,print,exit,undo,cut,copy,paste,delete,find,findn,findp,replace,got,select,time,font,zoom,status,word,in,out,restore;
    public void GUI(){
        jf.setTitle("Notepad Home");
        jf.getContentPane().setLayout(null);
        jf.setVisible(true);
        jf.setBounds(200,200,1000,700);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        JMenuBar mb=new JMenuBar();  
        menu=new JMenu("        Home       ");  

        neww=new JMenuItem("     New   "); 
        neww.addActionListener(this);
        nw=new JMenuItem("     New Window   ");  
        open=new JMenuItem("     Open   ");  
        save=new JMenuItem("     Save   ");  
        savea=new JMenuItem("     Save As   ");  
        page=new JMenuItem("     Page Setup   ");  
        print=new JMenuItem("     Print   ");  
        exit=new JMenuItem("     Exit   "); 
        
        { 
        nw.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        savea.addActionListener(this);
        page.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);

        menu.add(neww);   
        menu.add(nw);  
        menu.add(open);  
        menu.add(save);  
        menu.add(savea);
        menu.addSeparator();  
        menu.add(page);  
        menu.add(print);  
        menu.addSeparator();
        menu.add(exit);  
        }
  
        mb.add(menu);
        jf.setJMenuBar(mb);

        menu2=new JMenu("      Edit      ");  

        undo=new JMenuItem("     undo         "); 
        cut=new JMenuItem("     cut         ");  
        copy=new JMenuItem("     copy         ");  
        paste=new JMenuItem("     paste");  
        delete=new JMenuItem("     delete         ");  
        find=new JMenuItem("     find         ");  
        findn=new JMenuItem("     find Next         ");  
        findp=new JMenuItem("     find Pre         "); 
        replace=new JMenuItem("     replace         "); 
        got=new JMenuItem("     got         "); 
        select=new JMenuItem("     select         "); 
        time=new JMenuItem("     time         "); 
        font=new JMenuItem("     font         "); 
       
    {   
    undo.addActionListener(this);
    cut.addActionListener(this);
    copy.addActionListener(this);
    paste.addActionListener(this);
    delete.addActionListener(this);
    find.addActionListener(this);
    findn.addActionListener(this);
    findp.addActionListener(this);
    replace.addActionListener(this);
    got.addActionListener(this);
    select.addActionListener(this);
    time.addActionListener(this);
    font.addActionListener(this);

    menu2.add(undo);
    menu2.addSeparator();
    menu2.add(cut);
    menu2.add(copy);
    menu2.add(paste);
    menu2.add(delete);
    menu2.addSeparator();
    menu2.add(find);
    menu2.add(findn);
    menu2.add(findp);
    menu2.add(replace);
    menu2.add(got);
    menu2.addSeparator();
    menu2.add(select);
    menu2.add(time);
    menu2.addSeparator();
    menu2.add(font); 
    }

  

      mb.add(menu2);
        jf.setJMenuBar(mb);


        menu3=new JMenu("      View      "); 

        sub=new JMenu("      Zoom     ");
        
        status=new JMenuItem("     Status Bar         ");
        word=new JMenuItem("     Word Wrap         ");
        
        in=new JMenuItem("     Zoom In        ");
        out=new JMenuItem("     Zoom Out         ");
        restore=new JMenuItem("     Restore Default         ");

        in.addActionListener(this);
        out.addActionListener(this);
        restore.addActionListener(this);
        status.addActionListener(this);
        word.addActionListener(this);

        sub.add(in);
        sub.add(out);
        sub.add(restore);

        menu3.add(sub);
        menu3.add(status);
        menu3.add(word);
        mb.add(menu3);
        jf.setJMenuBar(mb);

        a = new JTextArea();   
        a.setBounds(0, 0, 1000,650);
        jf.add(a);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==neww){
            a.setText(null);
        }else if(e.getSource()==nw){
            ActionEventDemo s=new ActionEventDemo();
            s.GUI();
        }else if(e.getSource()==open){                      
             JFileChooser fc=new JFileChooser();

             int i=fc.showOpenDialog(new JFrame());

                if (i == JFileChooser.APPROVE_OPTION) {
                    File f = fc.getSelectedFile();
                    String filepath=f.getPath();

                    try{
                        BufferedReader br=new BufferedReader(new FileReader(filepath));
                        String sr1="",sr2="";
                        while((sr1=br.readLine())!=null){
                            sr2+=sr1+"\n";
                        }
                        a.setText(sr2);

                    }catch(Exception ex){ex.getStackTrace();}
                }

        }else if(e.getSource()==save){
            JFileChooser js=new JFileChooser();         
            int i=js.showSaveDialog(new JFrame());
            js.setDialogTitle("Save File");

            if(i==JFileChooser.APPROVE_OPTION){
                File f = js.getSelectedFile();
                int x=5;
                System.out.println(f.getPath());
                if(f.exists()==true){
                    x=JOptionPane.showConfirmDialog(js, "Kya kar raha hai be waha par pahale se hi hai ", "Save Error", i);
                    System.out.println(x);
                }else{

                    if(x==0){                   
                        
                        try {
                            a.write(new OutputStreamWriter(new FileOutputStream(f),"utf-8"));
                            jf.setTitle(f.getName());



                            
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            System.out.println(ex);
                        }
                }
                }

            }


            

        }
 
    }
}
 
public class first {
    public static void main(String[] args){

        ActionEventDemo s=new ActionEventDemo();
        s.GUI();
    }
}