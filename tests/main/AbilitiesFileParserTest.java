package main;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luckyfang0601 on 2017-05-30.
 */
public class AbilitiesFileParserTest {
    private AbilitiesFileParser abilities ;
    @Before
    public void beforeEachTest(){
        String testString = "Act Cute:deck:target:them:destination:deck:bottom:choice:target:1";
        String[] items = new String[]{"Act Cute","deck","target","them","destination","deck","bottom","choice","target","1"};
        abilities= new AbilitiesFileParser(items);
    }
    @Test
    public void parseName() throws Exception {
        abilities.parseName();
        assertEquals("Act Cute",abilities.getName());
    }

    @Test
    public void parseAction() throws Exception {
        abilities.parseName();
        abilities.parseAction();
        assertEquals("deck",abilities.getAction());
    }

    @Test
    public void parseLogic() throws Exception {
        abilities.parseName();
        abilities.parseAction();
        abilities.parseLogic();
        assertEquals("target:them:destination:deck:bottom:choice:target:1",abilities.getLogic());
    }

    @Test
    public void parseDescription() throws Exception {
        abilities.parseName();
        abilities.parseAction();
        abilities.parseLogic();
        abilities.parseDescription();
        assertEquals("Your opponent puts a card from his or her hand on the bottom of his or her deck.",abilities.getDescription());


    }


}