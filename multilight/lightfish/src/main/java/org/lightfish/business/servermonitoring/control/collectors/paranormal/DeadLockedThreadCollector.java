package org.lightfish.business.servermonitoring.control.collectors.paranormal;

import java.util.logging.Logger;
import org.lightfish.business.servermonitoring.control.collectors.AbstractRestDataCollector;
import org.lightfish.business.servermonitoring.control.collectors.DataPoint;
import org.lightfish.business.servermonitoring.control.collectors.SnapshotDataCollector;

/**
 *
 * @author Rob Veldpaus
 */
@SnapshotDataCollector
public class DeadLockedThreadCollector extends AbstractRestDataCollector<String> {

    private static final String DEADLOCKED_THREADS = "jvm/thread-system/deadlockedthreads";

    private static final Logger LOG = Logger.getLogger(DeadLockedThreadCollector.class.getName());

    @Override
    public DataPoint<String> collect() {
        String value = getString(DEADLOCKED_THREADS, "deadlockedthreads", "current");
        return new DataPoint<>("deadLockedThreads", value);
    }

}
