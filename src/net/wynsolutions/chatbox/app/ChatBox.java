package net.wynsolutions.chatbox.app;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * Copyright (C) 2017  Sw4p
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Sw4p
 *
 */
public class ChatBox extends VBox{
	
	private List<TextFlow> messages = new ArrayList<TextFlow>();
	private String contact;
	private ScrollPane sp = new ScrollPane();
	private TextFlow textFlow = new TextFlow();
	
	public ChatBox(String user) {
		
		this.contact = user;
		
        VBox vb = new VBox();
        
        textFlow.setLineSpacing(10);
       
        this.getChildren().addAll(sp,textFlow); 
        
        VBox.setVgrow(sp, Priority.ALWAYS);
        VBox.setVgrow(textFlow, Priority.ALWAYS);

        vb.getChildren().addAll(textFlow);
        this.sp.setVmax(440);
        this.sp.setPrefSize(380, 410);
        this.sp.setContent(vb);
        this.sp.vvalueProperty().bind((ObservableValue<? extends Number>) vb.heightProperty());
	}

	public void addMessage(String user, String message){
		 Text text;
         if(textFlow.getChildren().size()==0){
             text = new Text(user + message);
         } else {
             // Add new line if not the first child
             text = new Text("\n" + user + message);
         }
         textFlow.getChildren().add(text);
	}

	/**
	 * @return the messages
	 */
	public List<TextFlow> getMessages() {
		return messages;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	
}
