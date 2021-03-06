package com.spartansoftwareinc.ws.mt.lilt;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.spartansoftwareinc.lilt.api.Memory;
import com.spartansoftwareinc.ws.mt.lilt.UIMultiSelect.OptionValue;

@RunWith(MockitoJUnitRunner.class)
public class TestMemoryOptionBuilder {

    @Test
    public void testBuilder() throws Exception {
        List<Memory> response = new ArrayList<>();
        response.add(new Memory(1234, "en", "fr", "Test", 1));
        response.add(new Memory(1235, "en", "de", "Test", 1));
        response.add(new Memory(1236, "en", "de", "Another", 1));
        MemoryOptionBuilder builder = new MemoryOptionBuilder();
        List<OptionValue> values = builder.buildMemoryOptionsList(
                Collections.singleton(new Memory(1235, "en", "de", "Test", 1)), response);
        assertEquals(3, values.size());
        assertEquals("1235", values.get(0).id);
        assertEquals("Test (en -> de)", values.get(0).label);
        assertEquals(true, values.get(0).selected);
        assertEquals("1234", values.get(1).id);
        assertEquals("Test (en -> fr)", values.get(1).label);
        assertEquals(false, values.get(1).selected);
        assertEquals("1236", values.get(2).id);
        assertEquals("Another (en -> de)", values.get(2).label);
        assertEquals(false, values.get(2).selected);
    }
}
