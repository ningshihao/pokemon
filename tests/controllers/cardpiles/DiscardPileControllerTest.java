package controllers.cardpiles;

import ability.Dam;
import card.Energy;
import card.Pokemon;
import cardcontainer.DiscardPile;
import main.*;
import org.junit.Test;
import views.cardpiles.DiscardPileView;
import views.cardpiles.PileView;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by luckyfang0601 on 2017-06-01.
 */
public class DiscardPileControllerTest {
    private DiscardPile discardPile;
    private DiscardPileView discardPileView;
    private DiscardPileController discardPileController;
    private Pokemon pokemon;
@Test
    public void addCards(){
    discardPile = new DiscardPile();
    discardPileView = new DiscardPileView();
    discardPileController = new DiscardPileController(discardPile,discardPileView);
    ArrayList<Energy> energyArray= new ArrayList<Energy>(20);
    Retreat retreat = new Retreat("fighting",1);
    ArrayList<AbilityLogic> logic = new ArrayList<AbilityLogic>();
    logic.add(new Dam(new ArrayList<String>(Arrays.asList("dam:target:choice:opponent-bench:30"))));
    Ability ability = new Ability("Rain Splash","damage", logic);
    Requirement requirement=new Requirement("general",2);
    ArrayList<Requirement> requirements = new ArrayList<Requirement>();
    requirements.add(requirement);
    Attack attack = new Attack(requirements,ability);
    ArrayList<Attack> attacks = new ArrayList<Attack>();
    attacks.add(attack);
    pokemon = new Pokemon("Raichu", 27, "pokemon", 90,energyArray, "basic","",retreat,attacks);
    discardPileController.addCard(pokemon);
    assertEquals(1,discardPileController.getCardContainer().getNoOfCards());

}

}