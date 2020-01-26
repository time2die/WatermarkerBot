package BanModule;

import org.junit.Assert;
import org.junit.Test;


public class BanManagerTest {


    AccessManager accessManager = new BanManager();

    @Test
    public void testIfBlocked1(){
        long chat_id = 71263487615345345L;
        Assert.assertTrue(accessManager.ifBlocked(chat_id));
    }
    @Test
    public void testIfBlocked2(){
        long chat_id =32645236L;
        Assert.assertTrue(accessManager.ifBlocked(chat_id));
    }
    @Test
    public void testIfBlocked3(){
        long chat_id =2562456L;
        Assert.assertTrue(accessManager.ifBlocked(chat_id));
    }
    @Test
    public void testIfBlocked4(){
        long chat_id =123;
        Assert.assertFalse(accessManager.ifBlocked(chat_id));
    }
    @Test
    public void testIfBlocked5(){
        long chat_id=-123123L;
        Assert.assertFalse(accessManager.ifBlocked(chat_id));
    }
    @Test
    public void testBan(){
        accessManager.banUser(1342344L);
        Assert.assertTrue(accessManager.ifBlocked(1342344L));
    }


}