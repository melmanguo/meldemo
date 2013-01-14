package com.melman.meldemo.manager;

import android.util.SparseArray;
import com.melman.meldemo.data.DataListener;

public class DataListenerManager
{
	SparseArray<DataListener> _array;

	DataListenerManager()
	{
		_array = new SparseArray<DataListener>();
	}

	public void register(int id, DataListener listener)
	{
		_array.put(id, listener);
	}

	public void release(int id)
	{
		_array.remove(id);
	}

	public void dataChanged(int id, int type, Object obj)
	{
		DataListener listener = _array.get(id);
		if (listener != null)
		{
			listener.onDataChanged(type, obj);
		}
	}
}
