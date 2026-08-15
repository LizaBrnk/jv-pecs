package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl<T extends Machine>
        implements MachineService<T> {
    private BulldozerProducer bulldozerProducer = new BulldozerProducer();
    private ExcavatorProducer excavatorProducer = new ExcavatorProducer();
    private TruckProducer truckProducer = new TruckProducer();

    @Override
    public List<T> getAll(Class<? extends T> type) {
        if (type == Bulldozer.class) {
            List<? extends Machine> machines = bulldozerProducer.get();
            return (List<T>) new ArrayList<>(machines);
        }
        if (type == Excavator.class) {
            List<? extends Machine> machines = excavatorProducer.get();
            return (List<T>) new ArrayList<>(machines);
        }
        if (type == Truck.class) {
            List<? extends Machine> machines = truckProducer.get();
            return (List<T>) new ArrayList<>(machines);
        }

        return new ArrayList<>();
    }

    @Override
    public void fill(List<? super T> machines, T value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (Machine machine : machines) {
            machine.doWork();
        }
    }
}
