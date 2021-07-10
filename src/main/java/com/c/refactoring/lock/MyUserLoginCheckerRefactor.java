package com.c.refactoring.lock;

import java.util.Date;
import java.util.List;

public class MyUserLoginCheckerRefactor {

    public static final int MAXIMUM_LOCK_PERIOD_IN_MS = 60 * 60 * 1000;

    /**
     * {@inheritDoc}.
     */
    public Lock isUserAllowedToLogin(long id, String status,
            boolean firstScreen, User user, List existingLocks) {
        Date time = new Date();
        Lock lock = new Lock();
        if (existingLocks.size() > 0 && existingLocks.get(0) != null) {
            Object[] existingLock = (Object[]) existingLocks.get(0);
            String userIdWithLock = (String) existingLock[0];
            Date lockTimestamp = (Date) existingLock[1];
            if (userIdWithLock != null) {
                String lockMsg = Constants.LOCK_TEXT.replaceAll("@@USER@@",
                        userIdWithLock);
                boolean isMaximumLockPeriodExceeded = time.getTime() - lockTimestamp.getTime() > MAXIMUM_LOCK_PERIOD_IN_MS;
                if (isMaximumLockPeriodExceeded) {
                    if (firstScreen
                            || userIdWithLock.equalsIgnoreCase(user.getUserId())) {
                        //to set the  access to write mode
                        lock.setRead(false);
                        return lock;
                    }
                    lock.setRead(true);
                    //Only read access is permitted to other user
                    lock.setLockReason(lockMsg);
                    return lock;
                } else if (userIdWithLock.equalsIgnoreCase(user.getUserId())) {
                    // Locked By Same User, Write access
                    lock.setRead(false);
                    return lock;
                } else {
                    lock.setRead(true);
                    //Only Read Access is Permitted
                    lock.setLockReason(lockMsg);
                    return lock;
                }
            }
        }
        lock.setRead(false);
        return lock;
    }
}