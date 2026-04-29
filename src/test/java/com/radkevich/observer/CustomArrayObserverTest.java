package com.radkevich.observer;

import com.radkevich.entity.CustomArray;
import com.radkevich.entity.Statistics;
import com.radkevich.exeption.WarehouseException;
import com.radkevich.obsrver.CustomArrayObserver;
import com.radkevich.obsrver.impl.CustomArrayObserverImpl;
import com.radkevich.warehause.impl.WarehouseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class CustomArrayObserverTest {

    @Test
    public void testObserverUpdatesWarehouse() throws WarehouseException {
        WarehouseImpl warehouse = WarehouseImpl.getInstance();
        long arrayId = 1L;


        if (warehouse.isPresent(arrayId)) {
            warehouse.remove(arrayId);
        }

        CustomArray array = new CustomArray(arrayId, 10, 20, 30);

        CustomArrayObserver observer = new CustomArrayObserverImpl();
        array.attach(observer);


        Statistics initialStats = new Statistics(10, 30, 60, 20.0);
        warehouse.add(arrayId, initialStats);


        array.setElement(0, 100);


        Optional<Statistics> updatedStats = warehouse.get(arrayId);

        Assertions.assertTrue(updatedStats.isPresent(), "Statistics should be present in warehouse");
        Assertions.assertEquals(150, updatedStats.get().getSum(), "Sum in warehouse should be updated to 150");
        Assertions.assertEquals(100, updatedStats.get().getMax(), "Max in warehouse should be updated to 100");
    }
}
