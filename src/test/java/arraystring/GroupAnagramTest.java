package arraystring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GroupAnagramTest {

    @Test
    void testIt() {

        GroupAnagram groupAnagram = new GroupAnagram();
        List<List<String>> result = groupAnagram.groupAnagrams(new String[]{"eat", "tea", "tan", "eat", "ate", "nat", "bat"});
        List<List<String>> result2 = groupAnagram.groupAnagramsBestPerformance(new String[]{"eat", "tea", "tan", "eat", "ate", "nat", "bat"});
        Assertions.assertEquals(3, result.size());

    }

}