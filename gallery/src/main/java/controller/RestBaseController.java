package controller;

import entity.RestBaseControllerEntity;

public abstract class RestBaseController {

	protected static <T> RestBaseControllerEntity<T> ok(T context) {
		return RestBaseControllerEntity.ok(context);
	}

	protected static <T> RestBaseControllerEntity<T> error(T context) {
		return RestBaseControllerEntity.error(context);
	}
}
