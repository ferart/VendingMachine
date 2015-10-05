package arthur.mobileapps.com.vendingmachine.ui.utils;

import android.graphics.Bitmap;

import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arthur Rocha on 08/06/2015.
 * Clase encargada de obtener la imagen de la memoria cache del dispositivo
 *
 */
public class MemoryCache {
	private Map<String, SoftReference<Bitmap>> cache = Collections
			.synchronizedMap(new HashMap<String, SoftReference<Bitmap>>());

	/**
	 * Metodo encargado de obtener el mapa de bits
	 *
	 * @param id
	 * @return
	 */
	public Bitmap get(String id) {
		if (!cache.containsKey(id))
			return null;
		SoftReference<Bitmap> ref = cache.get(id);
		return ref.get();
	}

	/**
	 * Metodo encargado de asignar el mapa de bits de la imagen
	 *
	 * @param id
	 * @param bitmap
	 */
	public void put(String id, Bitmap bitmap) {
		cache.put(id, new SoftReference<Bitmap>(bitmap));
	}

	/**
	 * Metodo encargado de limpiar la memoria
	 */
	public void clear() {
		cache.clear();
	}
}
