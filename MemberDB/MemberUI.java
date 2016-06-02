package MemberDB;
import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MemberUI extends JPanel {

	   private static final long serialVersionUID = 1L;
	   private JTextField userNameEntry = new JTextField(30);
	   private JTextField passwordEntry = new JTextField(30);
	   private JTextField firstNameEntry = new JTextField(30);
	   private JTextField lastNameEntry = new JTextField(30);
	   private JTextField emailEntry = new JTextField(30);
	   private JTextField phoneEntry = new JTextField(30);
	   

	   private JButton createButton = new JButton("Add");
	   private JButton updateButton = new JButton("Update");
	   private JButton deleteButton = new JButton("Delete");
	   private JButton firstButton = new JButton("Top");
	   private JButton prevButton = new JButton("Prev");
	   private JButton nextButton = new JButton("Next");
	   private JButton lastButton = new JButton("Last");
	   
	   Connection conn;
	   private MemberController controller = new MemberController();

	   public MemberUI() {
	      setBorder(new TitledBorder
	      (new EtchedBorder(),"Member Details"));
	      setLayout(new BorderLayout(5, 5));
	      add(initFields(), BorderLayout.NORTH);
	      add(initButtons(), BorderLayout.CENTER);
	  //    setFieldData(controller.moveFirst());
	   }

	   private JPanel initButtons() {
	      JPanel panel = new JPanel();
	      panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
	      panel.add(createButton);
	      createButton.addActionListener(new ButtonHandler());
	      panel.add(updateButton);
	      updateButton.addActionListener(new ButtonHandler());
	      panel.add(deleteButton);
	      deleteButton.addActionListener(new ButtonHandler());
	      panel.add(firstButton);
	      firstButton.addActionListener(new ButtonHandler());
	      panel.add(prevButton);
	      prevButton.addActionListener(new ButtonHandler());
	      panel.add(nextButton);
	      nextButton.addActionListener(new ButtonHandler());
	      panel.add(lastButton);
	      lastButton.addActionListener(new ButtonHandler());
	      return panel;
	   }

	   private JPanel initFields() {
	      JPanel panel = new JPanel();
	      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	      panel.add(new JLabel("Username"));
	      panel.add(userNameEntry);
	      userNameEntry.setEnabled(true);
	      panel.add(new JLabel("Password"));
	      panel.add(passwordEntry);
	      passwordEntry.setEnabled(true);
	      panel.add(new JLabel("First Name"));
	      panel.add(firstNameEntry);
	      firstNameEntry.setEnabled(true);
	      panel.add(new JLabel("Last Name"));
	      panel.add(lastNameEntry);
	      lastNameEntry.setEnabled(true);
	      panel.add(new JLabel("Email"));
	      panel.add(emailEntry);
	      emailEntry.setEnabled(true);
	      panel.add(new JLabel("Phone"));
	      panel.add(phoneEntry);
	      phoneEntry.setEnabled(true);
	      return panel;
	   }

	   private Member getFieldData() {

	     String newUserName = userNameEntry.getText();
	     String newFirstName = passwordEntry.getText();
	     String newMiddleName = firstNameEntry.getText();
	     String newLastName = lastNameEntry.getText();
	     String newEmail = emailEntry.getText();
	     String newPhone = phoneEntry.getText();
    
	     Member member = new Member(newUserName, newFirstName, newMiddleName, newLastName, newEmail, newPhone);
	     return member;
	     
	     
	   }

	   private void setFieldData(Member member) {
	      userNameEntry.setText(member.getUserName());
	      passwordEntry.setText(member.getPassword());
	      firstNameEntry.setText(member.getFirstName());
	      lastNameEntry.setText(member.getLastName());
	      emailEntry.setText(member.getEmail());
	      phoneEntry.setText(member.getPhone());
	   }

	   private boolean isEmptyFieldData() {
	      return (passwordEntry.getText().trim().isEmpty()
	         && firstNameEntry.getText().trim().isEmpty()
	         && lastNameEntry.getText().trim().isEmpty()
	         && emailEntry.getText().trim().isEmpty()
	         && phoneEntry.getText().trim().isEmpty());
	   }

	   private class ButtonHandler implements ActionListener {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	         Member member = getFieldData();
	         switch (e.getActionCommand()) {
	         case "Save":
	            if (isEmptyFieldData()) {
	               JOptionPane.showMessageDialog(null,
	               "Cannot create an empty record");
	               return;
	            }
	            if (controller.create(member) != null)
	               JOptionPane.showMessageDialog(null,
	               "New member created successfully.");
	               createButton.setText("Add");
	               break;
	         case "Add":
	            member.setUserName("");
	            member.setFirstName("");
	            member.setMiddleName("");
	            member.setLastName("");
	            member.setEmail("");
	            member.setPhone("");
	            setFieldData(member);
	            createButton.setText("Save");
	            break;
	         case "Update":
	            if (isEmptyFieldData()) {
	               JOptionPane.showMessageDialog(null,
	               "Cannot update an empty record");
	               return;
	            }
	            if (controller.update(member) != null)
	               JOptionPane.showMessageDialog(
	               null,"Member with Username:" + String.valueOf(member.getUserName()
	               + " is updated successfully"));
	               break;
	         case "Delete":
	            if (isEmptyFieldData()) {
	               JOptionPane.showMessageDialog(null,
	               "Cannot delete an empty record");
	               return;
	            }
	            controller.delete(member);
	            JOptionPane.showMessageDialog(
	               null,"Member with Username:"
	               + String.valueOf(member.getUserName()
	               + " is deleted successfully"));
	               break;
/*	         case "Top":
	            setFieldData(controller.moveFirst()); 
	            break;
	         case "Previous":
	            setFieldData(controller.movePrevious()); 
	            break;
	         case "Next":
	            setFieldData(controller.moveNext()); 
	            break;
	         case "Last":
	            setFieldData(controller.moveLast()); 
	            break;*/
	         default:
	            JOptionPane.showMessageDialog(null,
	            "invalid command");
	         }
	      }
	   }
	}