package ds.linkedlist;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static ds.linkedlist.LinkedListMasterData.EMPTY_LINKED_LIST;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemovingDuplicateInUnSortedLLTest {

    @InjectMocks
    RemovingDuplicateInUnSortedLL inUnSortedLL;

    @Test
    public void testWithEmptyLinkedList() {
        assertEquals(inUnSortedLL.removeDuplicateWithoutBuffer(EMPTY_LINKED_LIST), null);
    }
}
