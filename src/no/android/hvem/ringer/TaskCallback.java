package no.android.hvem.ringer;

public interface TaskCallback {
	public void onComplete(InfoPack infopack);
	public void onError(String error);
}