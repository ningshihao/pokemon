package views.cardcontainer;

import views.card.CardView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class CardContainerView extends JScrollPane{

    private JPanel panel;
    private ArrayList<CardView> cardViews;

    public CardContainerView(int initialCapacity){

        cardViews = new ArrayList<CardView>(initialCapacity);

        setPreferredSize(new Dimension(450, 180));
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        panel = new JPanel();
        setViewportView(panel);
    }

    public ArrayList<CardView> getCardViews(){
        return cardViews;
    }

    public void addCardView(CardView newView){

        cardViews.add(newView);
        panel.add(newView);

    }

    public CardView removeCardView(CardView cardViewToRemove) {

        CardView returnedView = null;
        for(CardView view: cardViews){
            if (view == cardViewToRemove ){
                returnedView = view;
                panel.remove(view);
                cardViews.remove(view);
                break;
            }
        }
        return returnedView;

    }

}