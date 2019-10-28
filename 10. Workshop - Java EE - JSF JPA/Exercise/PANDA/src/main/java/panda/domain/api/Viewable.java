package panda.domain.api;

import java.io.Serializable;

/**
 * Viewable model markup interface.
 * Provides type-safety in generic methods and abstract classes
 *
 * @param <E> Entity class to which this Viewable model applies to
 */
public interface Viewable<E> extends Serializable {
}
