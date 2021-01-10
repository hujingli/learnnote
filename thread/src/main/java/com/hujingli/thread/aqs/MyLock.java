package com.hujingli.thread.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MyLock {

    private final Sync sync;

    public MyLock(Sync sync) {
        this.sync = sync;
    }

    private static class Sync extends AbstractQueuedSynchronizer{
        protected Sync() {
            super();
        }

        /**
         * ��ȡ��
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            // cas��ȡ��
            if (compareAndSetState(0, 1)) {
                // ��ȡ�ɹ�������״̬Ϊ1
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            // ������ȡ��ʧ��
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {

            return super.tryRelease(arg);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }

        @Override
        protected boolean isHeldExclusively() {
            // �Ƿ���ռ��״̬
            return getState() == 1;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public void lock() {
        sync.acquire(1);
    }

}
